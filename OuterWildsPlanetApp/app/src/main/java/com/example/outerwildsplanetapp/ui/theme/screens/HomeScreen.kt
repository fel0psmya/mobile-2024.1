package com.example.outerwildsplanetapp.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.outerwildsplanetapp.models.CelestialBody
import com.example.outerwildsplanetapp.models.celestialBodiesList
import com.example.outerwildsplanetapp.ui.theme.components.PlanetListItem
import com.example.outerwildsplanetapp.ui.theme.components.TopAppBarWithMenu

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(
    onCelestialBodySelected: (CelestialBody) -> Unit,
    onSettingsClick: () -> Unit,
    onHelpClick: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }

    val filteredCelestialBodies = remember(searchQuery) {
        celestialBodiesList.filter { it.name.contains(searchQuery, ignoreCase = true) }
    }

    val recentSearches = remember { mutableListOf<CelestialBody>() }

    Scaffold (
        topBar = {
            TopAppBarWithMenu(
                onSettingsClick = onSettingsClick,
                onHelpClick = onHelpClick
            )
        }
    ) { innerPadding ->
        Column (
            modifier = Modifier.padding(innerPadding)
        ) {
            // Search Bar
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Pesquisar") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding()
            )

            // LazyRow to Recent Searches
            LazyRow (
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
                horizontalArrangement =  Arrangement.spacedBy(8.dp)
            ) {
                items(recentSearches) { celestialBody ->
                    Button(onClick = { onCelestialBodySelected(celestialBody) }) {
                        Text(celestialBody.name)
                    }
                }
            }

            // LazyColumn to Filtered Celestial Bodies List
            LazyColumn (
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                items(filteredCelestialBodies) { celestialBody ->
                    PlanetListItem(
                        celestialBody = celestialBody,
                        onCelestialBodySelected = { selectedCelestialBody ->
                            if (!recentSearches.contains(selectedCelestialBody)) {
                                recentSearches.add(0, selectedCelestialBody)
                            }
                            onCelestialBodySelected(selectedCelestialBody)
                        },
                        onFavoriteToggle = { favoriteCelestialBody ->
                            favoriteCelestialBody.isFavorite = !favoriteCelestialBody.isFavorite
                        }
                    )
                }
            }
        }
    }
}