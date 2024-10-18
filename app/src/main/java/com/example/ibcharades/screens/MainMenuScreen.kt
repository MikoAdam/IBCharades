package com.example.ibcharades.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MainMenuScreen(onPlayClick: () -> Unit, onScoreBoardClick: () -> Unit, onAddDeckClick: () -> Unit) {
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
            onClick = onScoreBoardClick,
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .padding(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF26A69A)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Scoreboard (Coming Soon)", fontSize = 22.sp, color = Color.White)  // Placeholder text

        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onAddDeckClick,  // New button for the "Add Deck" feature
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .padding(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF80CBC4)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Add Deck (Coming Soon)", fontSize = 22.sp, color = Color.White)  // Placeholder text
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Settings Placeholder */ },
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .padding(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF80CBC4)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Settings (Coming Soon)", fontSize = 22.sp, color = Color.White)
        }
    }
}

