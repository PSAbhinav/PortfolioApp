package com.example.portfolioapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {

    object Home : Screen("home", "Home", Icons.Default.Home)

    object Projects : Screen("projects", "Projects", Icons.Default.Work)

    object Skills : Screen("skills", "Skills", Icons.Default.Star)

    object Contact : Screen("contact", "Contact", Icons.Default.Email)
}