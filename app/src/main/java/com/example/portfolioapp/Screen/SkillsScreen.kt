package com.example.portfolioapp.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolioapp.R
import com.example.portfolioapp.ui.ParticleBackground

data class Skill(
    val name: String,
    val icon: Int,
    val level: Float
)

@Composable
fun SkillsScreen() {

    val languages = listOf(
        Skill("Kotlin", R.drawable.kotlin, 0.9f)
    )

    val frameworks = listOf(
        Skill("Jetpack Compose", R.drawable.compose, 0.85f),
        Skill("Material Design", R.drawable.figma, 0.8f)
    )

    val tools = listOf(
        Skill("Android Studio", R.drawable.androidstudio, 0.9f),
        Skill("Git & GitHub", R.drawable.github, 0.75f)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF0F2027),
                        Color(0xFF203A43),
                        Color(0xFF2C5364)
                    )
                )
            )
    ) {

        ParticleBackground()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Text(
                "Tech Stack",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                "Technologies I use to build Android applications",
                color = Color.White.copy(alpha = 0.7f)
            )

            Spacer(modifier = Modifier.height(30.dp))

            SkillCategory("Languages", languages)

            Spacer(modifier = Modifier.height(20.dp))

            SkillCategory("Frameworks", frameworks)

            Spacer(modifier = Modifier.height(20.dp))

            SkillCategory("Tools", tools)
        }
    }
}

@Composable
fun SkillCategory(title: String, skills: List<Skill>) {

    Text(
        title,
        fontSize = 20.sp,
        color = Color.White
    )

    Spacer(modifier = Modifier.height(10.dp))

    skills.forEach {

        SkillCard(it)

        Spacer(modifier = Modifier.height(14.dp))
    }
}

@Composable
fun SkillCard(skill: Skill) {

    val animatedProgress by animateFloatAsState(
        targetValue = skill.level,
        animationSpec = tween(1000),
        label = ""
    )

    Card(
        shape = RoundedCornerShape(18.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.9f)
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(skill.icon),
                    contentDescription = skill.name,
                    modifier = Modifier.size(28.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    skill.name,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            LinearProgressIndicator(
                progress = animatedProgress,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp),
                color = Color(0xFF6A5ACD),
                trackColor = Color.LightGray
            )
        }
    }
}