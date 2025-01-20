package com.example.postapp.viewmodel

import android.widget.Toast
import androidx.annotation.OptIn
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.util.Log
import androidx.media3.common.util.UnstableApi
import com.example.postapp.data.RetrofitInstance
import com.example.postapp.data.models.CreatePostRequest
import com.example.postapp.data.models.Post
import com.example.postapp.data.models.User
import com.example.postapp.data.models.UserCreateRequest
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {
    var posts: List<Post> by mutableStateOf(listOf())
    var users: List<User> by mutableStateOf(listOf())
    private val userId = 1

    fun fetchUsers(){
        viewModelScope.launch {
            try {
                users = RetrofitInstance.api.getUsers()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun fetchPosts(){
        viewModelScope.launch {
            try {
                posts = RetrofitInstance.api.getPosts(userId)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun createUser(
        name: String,
        email: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        // Verifica se os campos estão vazios ou nulos
        if (name.isBlank() || email.isBlank()) {
            // Caso algum campo esteja vazio, chama a função de erro
            onError()
            return
        }

        viewModelScope.launch {
            try {
                val newUser = UserCreateRequest(name, email)
                RetrofitInstance.api.createUser(newUser)
                fetchUsers()
                onSuccess()
            } catch (e: Exception) {
                e.printStackTrace()
                onError()
            }
        }
    }

    fun createPost(
        title: String,
        content: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        // Verifica se os campos estão vazios ou nulos
        if (title.isBlank() || content.isBlank()) {
            // Caso algum campo esteja vazio, chama a função de erro
            onError()
            return
        }

        viewModelScope.launch {
            try {
                val newPost = CreatePostRequest(title, content)
                RetrofitInstance.api.createPost(userId, newPost)
                fetchPosts()
                onSuccess()
            } catch (e: Exception) {
                e.printStackTrace()
                onError()
            }
        }
    }

    @OptIn(UnstableApi::class)
    fun deletePost(postId: Int) {
        viewModelScope.launch {
            try {
                RetrofitInstance.api.deletePost(postId)
                fetchPosts()
                Log.d("PostViewModel", "Post $postId deletado com sucesso")
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("PostViewModel", "Erro ao deletar o post $postId: ${e.message}")
            }
        }
    }

    @OptIn(UnstableApi::class)
    fun updatePost(postId: Int, title: String, content: String) {
        // Verifica se os campos estão vazios ou nulos
        if (title.isBlank() || content.isBlank()) {
            return
        }

        viewModelScope.launch {
            try {
                val updatePost = CreatePostRequest(title, content)
                RetrofitInstance.api.updatePost(postId, updatePost)
                fetchPosts()
                Log.d("PostViewModel", "Post $postId atualizado com sucesso")
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("PostViewModel", "Erro ao atualizar o post $postId: ${e.message}")
            }
        }
    }
}