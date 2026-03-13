package com.example.portfolioapp.ui

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

data class Particle(
    val x: Float,
    val y: Float,
    val radius: Float,
    val speed: Float
)

@Composable
fun ParticleBackground() {

    val particles = remember {
        List(30) {
            Particle(
                x = Random.nextFloat(),
                y = Random.nextFloat(),
                radius = Random.nextFloat() * 8f + 3f,
                speed = Random.nextFloat() * 0.002f + 0.001f
            )
        }
    }

    val infiniteTransition = rememberInfiniteTransition(label = "")

    val animation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(20000),
            repeatMode = RepeatMode.Restart
        ),
        label = ""
    )

    Canvas(modifier = Modifier.fillMaxSize()) {

        particles.forEach { particle ->

            val newY = (particle.y + animation * particle.speed * 100) % 1f

            drawCircle(
                color = Color.White.copy(alpha = 0.15f),
                radius = particle.radius,
                center = Offset(
                    x = size.width * particle.x,
                    y = size.height * newY
                )
            )
        }
    }
}