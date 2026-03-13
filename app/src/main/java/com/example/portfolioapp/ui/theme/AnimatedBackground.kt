package com.example.portfolioapp.ui

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*

@Composable
fun AnimatedBackground(content: @Composable () -> Unit) {

    val transition = rememberInfiniteTransition()

    val color1 by transition.animateColor(
        initialValue = Color(0xFF6A5ACD),
        targetValue = Color(0xFF8A2BE2),
        animationSpec = infiniteRepeatable(
            tween(4000),
            RepeatMode.Reverse
        )
    )

    val color2 by transition.animateColor(
        initialValue = Color(0xFF1F1F2E),
        targetValue = Color(0xFF2B2B3C),
        animationSpec = infiniteRepeatable(
            tween(4000),
            RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(listOf(color1, color2))
            )
    ) {
        content()
    }
}