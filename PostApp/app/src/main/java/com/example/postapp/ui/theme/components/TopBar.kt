package com.example.postapp.ui.theme.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow

@ExperimentalMaterial3Api
@Composable
fun TopBar(
    onOpenDrawer: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "PostApp",
                style = MaterialTheme.typography.titleLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = onOpenDrawer) { // Open menu by clicking on the icon
                Icon(Icons.Default.Menu, contentDescription = "Open Menu")
            }
        }
    )
}