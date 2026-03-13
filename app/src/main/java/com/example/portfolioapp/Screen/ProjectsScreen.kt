package com.example.portfolioapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.portfolioapp.R
import com.example.portfolioapp.ui.ParticleBackground

data class Project(
    val name: String,
    val description: String,
    val image: Int,
    val details: String
)

@Composable
fun ProjectsScreen() {

    var selectedProject by remember { mutableStateOf<Project?>(null) }

    val projects = listOf(

        Project(
            "Happy Birthday App",
            "Compose greeting card application",
            R.drawable.happy_birthday,
            "This app demonstrates basic Jetpack Compose UI components. It shows a greeting card with styled text and background image."
        ),

        Project(
            "Business Card App",
            "Business card UI using Compose",
            R.drawable.business_card,
            "This application displays a digital business card using Compose layouts such as Column and Row."
        ),

        Project(
            "Art Gallery App",
            "Image gallery navigation project",
            R.drawable.art_gallery,
            "A gallery app that lets users browse artwork images using navigation buttons."
        ),

        Project(
            "Dice Roller",
            "Random dice generator",
            R.drawable.dice_roller,
            "A simple app that rolls a dice and generates random values using Kotlin logic."
        ),

        Project(
            "Tip Calculator",
            "Restaurant tip calculator",
            R.drawable.tip_calculator,
            "An Android app that calculates restaurant tips based on bill amount and tip percentage."
        ),

        Project(
            "Task Manager",
            "Simple task manager",
            R.drawable.task_manager,
            "A productivity app that helps users organize daily tasks using a structured list."
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF141E30),
                        Color(0xFF243B55)
                    )
                )
            )
    ) {

        ParticleBackground()

        LazyColumn(
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            item {

                Text(
                    "My Projects",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    "Android applications built using Kotlin and Jetpack Compose",
                    color = Color.White.copy(alpha = 0.7f)
                )
            }

            items(projects) { project ->

                Card(
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White.copy(alpha = 0.9f)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { selectedProject = project }
                ) {

                    Column {

                        Image(
                            painter = painterResource(project.image),
                            contentDescription = project.name,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(160.dp)
                        )

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(
                                project.name,
                                style = MaterialTheme.typography.titleLarge
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                project.description,
                                color = Color.Gray
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Button(
                                onClick = { selectedProject = project }
                            ) {
                                Text("View Details")
                            }
                        }
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(80.dp)) }
        }

        if (selectedProject != null) {

            AlertDialog(

                onDismissRequest = { selectedProject = null },

                title = {
                    Text(selectedProject!!.name)
                },

                text = {
                    Text(selectedProject!!.details)
                },

                confirmButton = {
                    Button(onClick = { selectedProject = null }) {
                        Text("Close")
                    }
                }
            )
        }
    }
}