package com.example.ibcharades.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
fun MainMenuScreen(onPlayClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF00796B), Color(0xFF004D40)) // Darker, modern gradient
                )
            ),
        contentAlignment = Alignment.Center // Ensures everything is centered
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Title of the game
            Text(
                text = "IBCharades",
                fontSize = 48.sp,
                fontWeight = FontWeight.ExtraBold, // Makes it stand out more
                color = Color.White,
                modifier = Modifier.padding(bottom = 40.dp) // Adds space below the title
            )

            // Play button
            Button(
                onClick = onPlayClick,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(60.dp), // Makes the button taller for better accessibility
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00E676)), // Green color for the button
                shape = RoundedCornerShape(24.dp) // Rounded corners for modern look
            ) {
                Text(text = "Play", fontSize = 22.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Settings button placeholder
            Button(
                onClick = { /* Settings placeholder */ },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF29B6F6)), // Blue for settings
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(text = "Settings (Coming Soon)", fontSize = 18.sp, fontWeight = FontWeight.Medium, color = Color.White)
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Credits button placeholder
            Button(
                onClick = { /* Credits placeholder */ },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7043)), // Orange for credits
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(text = "Credits (Coming Soon)", fontSize = 18.sp, fontWeight = FontWeight.Medium, color = Color.White)
            }
        }
    }
}

