package com.example.outerwildsplanetapp.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.outerwildsplanetapp.models.CelestialBody
import com.example.outerwildsplanetapp.models.celestialBodiesList
import com.example.outerwildsplanetapp.ui.theme.components.PlanetListItem

@ExperimentalMaterial3Api
@Composable
fun FavoritesScreen (
    onCelestialBodySelected: (CelestialBody) -> Unit,
    onFavoriteToggle: (CelestialBody) -> Unit
) {
    Scaffold (
        topBar = {
            TopAppBar (
                title = {
                    Text(
                        text = "Favorites",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        }
    ) { innerPadding ->
        val favoriteCelestialBodies = celestialBodiesList.filter { it.isFavorite }

        if (favoriteCelestialBodies.isEmpty()) {
            // Shows a default text when there is no favorites
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "You have not added favorites yet.",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            // Displays a list of favorites
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 8.dp)
            ) {
                items(favoriteCelestialBodies) { celestialBody ->
                    PlanetListItem(
                        celestialBody = celestialBody,
                        onCelestialBodySelected = { onCelestialBodySelected(it)},
                        onFavoriteToggle = { onFavoriteToggle(it) }
                    )
                }
            }
        }
    }
}