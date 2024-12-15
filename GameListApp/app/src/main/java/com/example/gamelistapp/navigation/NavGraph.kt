package com.example.gamelistapp.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gamelistapp.ui.screens.HomeScreen
import com.example.gamelistapp.ui.screens.GameScreen
import com.example.gamelistapp.models.gameList

@ExperimentalMaterial3Api
@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onGameSelected = { game ->
                navController.navigate("game/${game.name}")
            })
        }
        composable("game/{game}") { backStackEntry ->
            val gameName = backStackEntry.arguments?.getString("game")
            val selectedGame = gameList.first { it.name == gameName }
            GameScreen(selectedGame)
        }
    }
}
