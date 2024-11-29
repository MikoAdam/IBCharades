package com.example.ibcharades

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.os.CountDownTimer
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.ibcharades.screens.CountdownScreen
import com.example.ibcharades.screens.GameScreen
import com.example.ibcharades.screens.ScoreScreen
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
    private var gameStarted = false // Ensures tilt is detected only after countdown
    private var vibrationTriggered = false
    private var remainingTime = 60

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_FULLSCREEN       // Hides the status bar
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION   // Hides the navigation bar
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY  // Keeps the bars hidden
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE     // Stabilizes the layout
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN  // Fullscreen layout
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION  // Fullscreen layout hiding navigation
                )


        val deck = intent.getStringExtra("deck")
        words = (Decks.exampleDecks[deck] ?: listOf()).shuffled()

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator

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

        // Mark the game as started
        gameStarted = true

        gameTimer = object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                remainingTime = (millisUntilFinished / 1000).toInt()
                updateGameScreen()  // No need to pass remainingTime explicitly now
                if (millisUntilFinished <= 3000 && !vibrationTriggered) {
                    vibrationTriggered = true
                    val pattern = longArrayOf(0, 3000)// for 3 secs vibration
                    vibrator?.vibrate(pattern, -1)//false safe
                }
            }

            override fun onFinish() {
                showScoreScreen(guessedWords, skippedWords)
                vibrationTriggered = false
            }
        }.start()

        updateGameScreen() // Call this only once to initialize the first word
    }

    private fun updateGameScreen() {
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
                    remainingTime = remainingTime, // Use the class-level variable directly
                    vibrator = vibrator
                )
            }
        }
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
        if (!gameStarted || event == null) return  // Ignore sensor events before the game starts

        val z = event.values[2]  // Detect tilt on the Z-axis (front/back)

        if (isVertical && currentWordIndex < words.size) {
            if (z > 7) {  // Tilted backwards (guessed)
                vibrator?.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
                guessedWords.add(words[currentWordIndex])
                guessedCount++
                isVertical = false  // Block further tilts until the phone returns to vertical
                moveToNextWord()
            } else if (z < -7) {  // Tilted forward (skipped)
                vibrator?.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
                skippedWords.add(words[currentWordIndex])
                skippedCount++
                isVertical = false  // Block further tilts until the phone returns to vertical
                moveToNextWord()
            }
        } else if (z in -3f..3f) {
            isVertical = true  // Allow tilt detection again once the phone is vertical
        }
    }

    private fun moveToNextWord() {
        currentWordIndex++
        if (currentWordIndex >= words.size) {
            showScoreScreen(guessedWords, skippedWords)
        } else {
            updateGameScreen()  // Only update the screen, don't restart the timer
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    private fun showScoreScreen(guessedWords: List<String>, skippedWords: List<String>) {
        gameStarted = false  // Stop detecting tilts after the game ends
        setContent {
            IBCharadesTheme {
                ScoreScreen(guessedWords, skippedWords, onPlayAgain = {
                    startGame()
                }, onBackToDecks = {
                    finish()
                })
            }
        }
    }

}

