package com.example.postapp.ui.theme.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
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
import com.example.postapp.data.models.Post

@Composable
fun PostScreen(viewModel: PostViewModel = viewModel(), navController: NavHostController) {
    var title by remember { mutableStateOf("")  }
    var content by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var editingPost by remember { mutableStateOf<Post?>(null) }

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        isLoading = true
        viewModel.fetchPosts()
        isLoading = false
    }

    Column (
        modifier = Modifier
            .padding(16.dp)
    ) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text(text = "Título") },
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
            value = content,
            onValueChange = { content = it },
            label = { Text(text = "Conteúdo") },
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
                if (title.isBlank() || content.isBlank()) {
                    Toast.makeText(context, "Título e conteúdo não podem estar vazios", Toast.LENGTH_SHORT).show()
                } else {
                    isLoading = true
                    viewModel.createPost(
                        title,
                        content,
                        onSuccess = {
                            Toast.makeText(
                                context,
                                "Postagem criada com sucesso",
                                Toast.LENGTH_SHORT
                            ).show()
                            isLoading = false
                        },
                        onError = {
                            Toast.makeText(context, "Erro ao criar a postagem", Toast.LENGTH_SHORT)
                                .show()
                        }
                    )
                    title = ""
                    content = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Criar postagem")
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            LazyColumn {
                items(viewModel.posts) { post ->
                    PostItem(
                        post = post,
                        onDelete = { viewModel.deletePost(it) },
                        onEdit = { editingPost = it }
                    )
                }
            }
        }

        if (editingPost != null) {
            AlertDialog(
                onDismissRequest = {editingPost = null},
                title = { Text(text = "Editar postagem") },
                text = {
                    Column {
                        TextField(
                            value = editingPost!!.title,
                            onValueChange = {newTitle -> editingPost = editingPost!!.copy(title = newTitle)},
                            label = { Text(text = "Título") }
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        TextField(
                            value = editingPost!!.content,
                            onValueChange = {newContent -> editingPost = editingPost!!.copy(content = newContent)},
                            label = { Text(text = "Conteúdo") }
                        )
                    }
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            viewModel.updatePost(
                                editingPost!!.id,
                                editingPost!!.title,
                                editingPost!!.content)
                            editingPost = null
                        }
                    ) {
                        Text(text = "Salvar")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            editingPost = null
                        }
                    ) {
                        Text(text = "Cancelar")
                    }
                }
            )
        }
    }
}