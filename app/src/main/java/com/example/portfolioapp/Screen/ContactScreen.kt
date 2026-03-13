package com.example.portfolioapp.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolioapp.ui.ParticleBackground

@Composable
fun ContactScreen() {

    val context = LocalContext.current

    var message by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF1F4037),
                        Color(0xFF99F2C8)
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
                "Contact Me",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                "Let's connect or collaborate on projects.",
                color = Color.White.copy(alpha = 0.8f)
            )

            Spacer(modifier = Modifier.height(30.dp))

            ContactCard(
                icon = Icons.Default.Email,
                title = "Email",
                subtitle = "abhinavpemmaraju@gmail.com"
            ) {

                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:abhinavpemmaraju@gmail.com")
                }

                context.startActivity(intent)
            }

            Spacer(modifier = Modifier.height(16.dp))

            ContactCard(
                icon = Icons.Default.Person,
                title = "LinkedIn",
                subtitle = "linkedin.com/in"
            ) {

                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://linkedin.com/in/abhinav-pemmaraju-765221255")
                )

                context.startActivity(intent)
            }

            Spacer(modifier = Modifier.height(16.dp))

            ContactCard(
                icon = Icons.Default.Code,
                title = "GitHub",
                subtitle = "github.com/PSAbhinav"
            ) {

                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/PSAbhinav")
                )

                context.startActivity(intent)
            }

            Spacer(modifier = Modifier.height(30.dp))

            OutlinedTextField(
                value = message,
                onValueChange = { message = it },
                label = { Text("Send a message") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {

                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:abhinavpemmaraju@gmail.com")
                        putExtra(Intent.EXTRA_TEXT, message)
                    }

                    context.startActivity(intent)

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(30.dp)
            ) {
                Text("Send Email")
            }
        }
    }
}

@Composable
fun ContactCard(
    icon: ImageVector,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {

    Card(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                icon,
                contentDescription = null,
                tint = Color(0xFF6A5ACD)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {

                Text(
                    title,
                    fontSize = 18.sp
                )

                Text(
                    subtitle,
                    color = Color.Gray
                )
            }
        }
    }
}