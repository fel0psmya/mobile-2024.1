package com.example.outerwildsplanetapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.outerwildsplanetapp.models.celestialBodiesList
import com.example.outerwildsplanetapp.ui.theme.components.BottomNavigationBar
import com.example.outerwildsplanetapp.ui.theme.screens.DetailsScreen
import com.example.outerwildsplanetapp.ui.theme.screens.FavoritesScreen
import com.example.outerwildsplanetapp.ui.theme.screens.HomeScreen

sealed class BottomBarScreen(val route: String, val icon:@Composable () -> Unit, val label: String) {
    object Home : BottomBarScreen (
        route = "home",
        icon = {
            androidx.compose.material3.Icon(Icons.Default.Home, contentDescription = "Home")
        },
        label = "Home"
    )

    object Favorites : BottomBarScreen (
        route = "favorites",
        icon = {
            androidx.compose.material3.Icon(Icons.Default.Favorite, contentDescription = "Favorites")
        },
        label = "Favorites"
    )
}

@ExperimentalMaterial3Api
@Composable
fun NavGraph (
    onSettingsClick: () -> Unit,
    onHelpClick: () -> Unit
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomBarScreen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Home Screen
            composable(BottomBarScreen.Home.route) {
                HomeScreen(
                    onCelestialBodySelected = { celestialBody ->
                        navController.navigate("details/${celestialBody.name}")
                    },
                    onSettingsClick = onSettingsClick,
                    onHelpClick = onHelpClick
                )
            }

            // Favorites Screen
            composable(BottomBarScreen.Favorites.route) {
                FavoritesScreen(
                    onCelestialBodySelected = { celestialBody ->
                        navController.navigate("details/${celestialBody.name}")
                    },
                    onFavoriteToggle = { celestialBody ->
                        celestialBody.isFavorite = !celestialBody.isFavorite
                    }
                )
            }

            // Details Screen
            composable("details/{celestialBodyName}") { backStackEntry ->
                val celestialBodyName = backStackEntry.arguments?.getString("celestialBodyName")

                val selectedCelestialBody =
                    celestialBodiesList.first { it.name == celestialBodyName }
                DetailsScreen(selectedCelestialBody)
            }
        }
    }
}