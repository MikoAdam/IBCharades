package com.example.ibcharades

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.os.CountDownTimer
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ibcharades.ui.theme.IBCharadesTheme

class GameActivity : ComponentActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null
    private var vibrator: Vibrator? = null
    private var currentWordIndex = 0
    private var words = listOf<String>()
    private var guessedWords = mutableListOf<String>()
    private var skippedWords = mutableListOf<String>()
    private var guessedCount = 0
    private var skippedCount = 0
    private var gameTimer: CountDownTimer? = null
    private var isVertical = true // Ensures the phone returns to vertical before next tilt

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get the selected deck and its words
        val deck = intent.getStringExtra("deck")
        words = Decks.exampleDecks[deck] ?: listOf()

        // Sensor setup
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        // Vibration setup
        vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator

        // Lock orientation to landscape
        requestedOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        setContent {
            IBCharadesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { contentPadding ->
                    Box(modifier = Modifier.padding(contentPadding)) {
                        CountdownScreen(onStartGame = { startGame() })
                    }
                }
            }
        }
    }

    private fun startGame() {
        gameTimer?.cancel() // Reset timer if needed
        setContent {
            IBCharadesTheme {
                GameScreen(
                    words = words,
                    currentWordIndex = currentWordIndex,
                    guessedCount = guessedCount,
                    skippedCount = skippedCount,
                    onGameEnd = {
                        showScoreScreen(guessedWords, skippedWords)
                    },
                    onWordGuessed = {
                        guessedWords.add(it)
                        guessedCount++
                        moveToNextWord()
                    },
                    onWordSkipped = {
                        skippedWords.add(it)
                        skippedCount++
                        moveToNextWord()
                    },
                    vibrator = vibrator
                )
            }
        }

        // Start the game countdown (60 seconds)
        gameTimer = object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Update countdown logic if needed
            }

            override fun onFinish() {
                showScoreScreen(guessedWords, skippedWords)
            }
        }.start()
    }

    override fun onResume() {
        super.onResume()
        accelerometer?.also { sensor ->
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        // Handle front/back tilting
        if (event != null) {
            val z = event.values[2] // Check z-axis for face/back detection

            if (isVertical && currentWordIndex < words.size) {
                if (z > 7) { // Phone tilted on its back (guessed)
                    vibrator?.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
                    guessedWords.add(words[currentWordIndex])
                    guessedCount++
                    isVertical = false // Block further guesses until phone returns to vertical
                    moveToNextWord()
                } else if (z < -7) { // Phone tilted face down (skipped)
                    vibrator?.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
                    skippedWords.add(words[currentWordIndex])
                    skippedCount++
                    isVertical = false // Block further skips until phone returns to vertical
                    moveToNextWord()
                }
            } else if (z in -3f..3f) {
                isVertical = true // Reset to allow further guesses/skips
            }
        }
    }

    private fun moveToNextWord() {
        currentWordIndex++
        if (currentWordIndex >= words.size) {
            showScoreScreen(guessedWords, skippedWords)
        } else {
            startGame() // Refresh the GameScreen for the next word
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    private fun showScoreScreen(guessedWords: List<String>, skippedWords: List<String>) {
        setContent {
            IBCharadesTheme {
                ScoreScreen(guessedWords, skippedWords, onPlayAgain = {
                    startGame()  // Restart the game with the same deck
                }, onBackToDecks = {
                    finish()  // Close the activity and return to DeckSelection
                })
            }
        }
    }
}

@Composable
fun CountdownScreen(onStartGame: () -> Unit) {
    var countdown by remember { mutableStateOf(3) }

    LaunchedEffect(Unit) {
        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                countdown = (millisUntilFinished / 1000).toInt()
            }

            override fun onFinish() {
                onStartGame()
            }
        }.start()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Magenta, Color.Red)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$countdown",
            fontSize = 100.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
fun GameScreen(
    words: List<String>,
    currentWordIndex: Int,
    guessedCount: Int,
    skippedCount: Int,
    onGameEnd: () -> Unit,
    onWordGuessed: (String) -> Unit,
    onWordSkipped: (String) -> Unit,
    vibrator: Vibrator?
) {
    val currentWord = words.getOrNull(currentWordIndex) ?: "No more words"
    var countdown by remember { mutableStateOf(60) }

    LaunchedEffect(currentWord) {
        vibrator?.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
        object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                countdown = (millisUntilFinished / 1000).toInt()
            }

            override fun onFinish() {
                onGameEnd()
            }
        }.start()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.LightGray, Color.White)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            // Countdown
            Text(text = "$countdown", fontSize = 48.sp, color = Color.Black)

            // Current Word in the center
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = currentWord,
                fontSize = 96.sp, // Bigger size for visibility
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            // Stats for guessed and skipped
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Guessed: $guessedCount", fontSize = 24.sp, color = Color.Green)
                Text(text = "Skipped: $skippedCount", fontSize = 24.sp, color = Color.Red)
            }
        }
    }
}

@Composable
fun ScoreScreen(
    guessedWords: List<String>,
    skippedWords: List<String>,
    onPlayAgain: () -> Unit,
    onBackToDecks: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Game Over", fontSize = 48.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Guessed: ${guessedWords.size}", fontSize = 24.sp, color = Color.Green)
            Text(text = "Skipped: ${skippedWords.size}", fontSize = 24.sp, color = Color.Red)

            Spacer(modifier = Modifier.height(16.dp))

            // Display guessed and skipped words
            Column(modifier = Modifier.padding(16.dp)) {
                guessedWords.forEach { word ->
                    Text(text = word, color = Color.Green, fontSize = 20.sp)
                }
                skippedWords.forEach { word ->
                    Text(text = word, color = Color.Red, fontSize = 20.sp)
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Play again and back to decks buttons
            Button(onClick = onPlayAgain, modifier = Modifier.padding(16.dp)) {
                Text("Play Again")
            }

            Button(onClick = onBackToDecks, modifier = Modifier.padding(16.dp)) {
                Text("Back to Decks")
            }
        }
    }
}
