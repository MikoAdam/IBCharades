package com.example.ibcharades

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ibcharades.ui.theme.IBCharadesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IBCharadesTheme {
                var currentScreen by remember { mutableStateOf("MainMenu") }

                Scaffold(modifier = Modifier.fillMaxSize()) { contentPadding ->
                    Box(modifier = Modifier.padding(contentPadding)) {
                        when (currentScreen) {
                            "MainMenu" -> MainMenuScreen(
                                onPlayClick = { currentScreen = "DeckSelection" }
                            )
                            "DeckSelection" -> DeckSelectionScreen(
                                onStartGame = { selectedDeck ->
                                    // Navigate to GameActivity with the selected deck
                                    val intent = Intent(this@MainActivity, GameActivity::class.java)
                                    intent.putExtra("deck", selectedDeck)
                                    startActivity(intent)
                                },
                                onBack = { currentScreen = "MainMenu" }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MainMenuScreen(onPlayClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFF80DEEA), Color(0xFF00796B))))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "IBCharades",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onPlayClick,
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .padding(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF004D40)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Play", fontSize = 24.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Settings Placeholder */ },
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .padding(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF26A69A)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Settings (Coming Soon)", fontSize = 22.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Credits Placeholder */ },
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .padding(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF80CBC4)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Credits (Coming Soon)", fontSize = 22.sp, color = Color.White)
        }
    }
}

@Composable
fun DeckSelectionScreen(onStartGame: (String) -> Unit, onBack: () -> Unit) {
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
    val decks = Decks.exampleDecks.keys.toList().filter {
        it.contains(searchQuery.text, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFB2EBF2), Color(0xFF004D40))
                )
            )
            .padding(16.dp)
    ) {
        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth(0.7f),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Back", fontSize = 18.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Select a Deck",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomSearchBar(
            searchQuery = searchQuery,
            onSearchQueryChange = { searchQuery = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(decks) { deck ->
                DeckItem(deck = deck, onDeckClick = { onStartGame(deck) })
            }
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
fun DeckItem(deck: String, onDeckClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .clickable { onDeckClick() },
        colors = CardDefaults.cardColors(containerColor = Color(0xFF00897B)),
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
