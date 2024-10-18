package com.example.ibcharades.screens

import android.os.CountDownTimer
import android.os.Vibrator
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ibcharades.Decks

@Composable
fun DeckSelectionScreen(onStartGame: (String) -> Unit, onBack: () -> Unit) {
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
    val decks = Decks.exampleDecks.keys.toList().filter {
        it.contains(searchQuery.text, ignoreCase = true)
    }.sorted()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(colors = listOf(Color(0xFF80DEEA), Color(0xFF00796B))))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Back Button
            Button(
                onClick = onBack,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = "Back", fontSize = 18.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Title
            Text(
                text = "Select a Deck",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Search Bar
            CustomSearchBar(
                searchQuery = searchQuery,
                onSearchQueryChange = { searchQuery = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Deck List
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(decks) { deck ->
                    DeckItem(deck = deck, onDeckClick = { onStartGame(deck) })
                }
            }
        }
    }
}

@Composable
fun DeckItem(deck: String, onDeckClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .clickable { onDeckClick() },
        colors = CardDefaults.cardColors(containerColor = Color(0xFF004D40)),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.elevatedCardElevation(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = deck,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun CustomSearchBar(searchQuery: TextFieldValue, onSearchQueryChange: (TextFieldValue) -> Unit) {
    BasicTextField(
        value = searchQuery,
        onValueChange = onSearchQueryChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color(0xFFE0F7FA), shape = RoundedCornerShape(16.dp))
            .padding(16.dp),
        singleLine = true,
        textStyle = MaterialTheme.typography.bodyMedium.copy(color = Color.Black)
    )
}

@Composable
fun CountdownScreen(onStartGame: () -> Unit) {
    var countdown by remember { mutableIntStateOf(3) }

    LaunchedEffect(Unit) {
        object : CountDownTimer(4000, 1000) {  // Changed to 4000 ms to account for 3 seconds countdown
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
    remainingTime: Int, // New parameter for remaining time
    vibrator: Vibrator?
) {
    val currentWord = words.getOrNull(currentWordIndex) ?: "No more words"

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
            Text(text = "$remainingTime", fontSize = 48.sp, color = Color.Black)

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = currentWord,
                fontSize = 96.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

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
    // Force the content to be displayed in a vertical layout
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        // Wrapping the Column in a Box ensures it takes vertical alignment in landscape mode
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f) // Ensures content stays centered and narrower in landscape
                .padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()) // In case content is too tall
            ) {
                Text(
                    text = "Game Over",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Guessed: ${guessedWords.size}",
                    fontSize = 24.sp,
                    color = Color.Green
                )

                Text(
                    text = "Skipped: ${skippedWords.size}",
                    fontSize = 24.sp,
                    color = Color.Red
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Display guessed and skipped words
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Guessed Words:", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    guessedWords.forEach { word ->
                        Text(text = word, color = Color.Green, fontSize = 20.sp)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(text = "Skipped Words:", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    skippedWords.forEach { word ->
                        Text(text = word, color = Color.Red, fontSize = 20.sp)
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Play again button
                Button(
                    onClick = onPlayAgain,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(text = "Play Again", fontSize = 20.sp)
                }

                // Back to decks button
                Button(
                    onClick = onBackToDecks,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(text = "Back to Decks", fontSize = 20.sp)
                }
            }
        }
    }
}


