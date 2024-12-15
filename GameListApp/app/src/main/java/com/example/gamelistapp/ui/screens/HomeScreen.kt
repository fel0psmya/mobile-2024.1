package com.example.gamelistapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.gamelistapp.models.Game
import com.example.gamelistapp.models.gameList
import com.example.gamelistapp.ui.components.GameListItem

@Composable
fun HomeScreen (onGameSelected: (Game) -> Unit){
    var searchQuery by remember { mutableStateOf("") }
    val filteredGames = remember(searchQuery) {
        gameList.filter { it.name.contains(searchQuery, ignoreCase = true) }
    }

    Column {
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Pesquisar") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            items(filteredGames) { animal ->
                GameListItem(animal, onGameSelected)
            }
        }
    }
}