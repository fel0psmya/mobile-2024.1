package com.example.postapp.ui.theme.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.postapp.viewmodel.PostViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun UserScreen(viewModel: PostViewModel = viewModel(), navController: NavHostController) {
    var name by remember { mutableStateOf("")  }
    var email by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        isLoading = true
        viewModel.fetchUsers()
        isLoading = false
    }

    Column (
        modifier = Modifier
            .padding(16.dp)
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Nome") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface, // Cor de fundo adaptável ao tema
                focusedIndicatorColor = MaterialTheme.colors.primary, // Cor do indicador quando em foco
                unfocusedIndicatorColor = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled), // Cor do indicador quando fora de foco
                textColor = MaterialTheme.colors.onSurface, // Cor do texto
                cursorColor = MaterialTheme.colors.primary // Cor do cursor
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface, // Cor de fundo adaptável ao tema
                focusedIndicatorColor = MaterialTheme.colors.primary, // Cor do indicador quando em foco
                unfocusedIndicatorColor = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled), // Cor do indicador quando fora de foco
                textColor = MaterialTheme.colors.onSurface, // Cor do texto
                cursorColor = MaterialTheme.colors.primary // Cor do cursor
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (name.isBlank() || email.isBlank()) {
                    Toast.makeText(context, "Nome e email não podem estar vazios", Toast.LENGTH_SHORT).show()
                } else {
                    isLoading = true
                    viewModel.createUser(
                        name,
                        email,
                        onSuccess = {
                            Toast.makeText(
                                context,
                                "Usuário criado com sucesso",
                                Toast.LENGTH_SHORT
                            ).show()
                            isLoading = false
                        },
                        onError = {
                            Toast.makeText(context, "Erro ao criar o usuário", Toast.LENGTH_SHORT)
                                .show()
                        }
                    )
                    name = ""
                    email = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Criar usuário")
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            LazyColumn {
                items(viewModel.users) { user ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        elevation = 4.dp
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = "Nome: ${user.name}", style = MaterialTheme.typography.h6)
                            Text(text = "Email: ${user.email}", style = MaterialTheme.typography.body1)
                        }
                    }
                }
            }
        }
    }
}