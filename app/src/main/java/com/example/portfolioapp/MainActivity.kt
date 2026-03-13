package com.example.portfolioapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.example.portfolioapp.navigation.Screen
import com.example.portfolioapp.Screen.*
import com.example.portfolioapp.screens.ContactScreen
import com.example.portfolioapp.screens.HomeScreen
import com.example.portfolioapp.screens.ProjectsScreen
import com.example.portfolioapp.screens.SkillsScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortfolioApp()
        }
    }
}

@Composable
fun PortfolioApp() {

    val navController = rememberNavController()

    val items = listOf(
        Screen.Home,
        Screen.Projects,
        Screen.Skills,
        Screen.Contact
    )

    Scaffold(

        bottomBar = {

            NavigationBar {

                val currentRoute =
                    navController.currentBackStackEntryAsState().value?.destination?.route

                items.forEach { screen ->

                    NavigationBarItem(
                        icon = { Icon(screen.icon, screen.title) },
                        label = { Text(screen.title) },
                        selected = currentRoute == screen.route,
                        onClick = { navController.navigate(screen.route) }
                    )
                }
            }
        }

    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(padding)
        ) {

            composable(Screen.Home.route) { HomeScreen() }
            composable(Screen.Projects.route) { ProjectsScreen() }
            composable(Screen.Skills.route) { SkillsScreen() }
            composable(Screen.Contact.route) { ContactScreen() }

        }
    }
}