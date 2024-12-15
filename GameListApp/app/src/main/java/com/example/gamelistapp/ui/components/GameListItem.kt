package com.example.gamelistapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.gamelistapp.models.Game


@Composable
fun GameListItem(game: Game, onGameSelected: (Game) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Row para alinhar a imagem à esquerda
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Center, // Centraliza a imagem
                verticalAlignment = Alignment.CenterVertically // Alinha a imagem ao centro verticalmente

            ) {
                Image(
                    painter = rememberAsyncImagePainter(game.imageUrl),
                    contentDescription = "${game.name} Image",
                    modifier = Modifier
                        .size(200.dp) // Ajuste o tamanho da imagem conforme necessário
                        .clip(RoundedCornerShape(8.dp))
                )

                Spacer(modifier = Modifier.width(16.dp)) // Espaço entre a imagem e os outros elementos
            }

            // Column para colocar os outros elementos abaixo da imagem
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                // Título do jogo + ano de lançamento
                Text(
                    text = game.name,
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    text = game.releaseDate,
                    style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray),
                    modifier = Modifier.padding(top = 4.dp)
                )

                // Plataformas
                game.platforms?.let {
                    Text(
                        text = "Plataformas: ${it.joinToString(", ")}",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }

                // Descrição
                Text(
                    text = game.description,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top = 4.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(onClick = { onGameSelected(game) } ) {
                    Text("Mais sobre ${game.name}")
                }
            }
        }
    }
}