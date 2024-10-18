package com.example.ibcharades

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.ibcharades.screens.DeckSelectionScreen
import com.example.ibcharades.screens.MainMenuScreen
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
