package com.example.taskmanagerapp.models

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskmanagerapp.ui.components.DataStoreUtils
import com.example.taskmanagerapp.ui.components.Task
import com.example.taskmanagerapp.ui.components.TaskCategory
import com.example.taskmanagerapp.ui.components.TaskPriority
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TasksViewModel(context: Context) : ViewModel() {
    private val _tasks = MutableStateFlow(
        listOf(
            Task("Reunião importante", false, TaskCategory.TRABALHO, TaskPriority.ALTA),
            Task("Estudar Jetpack Compose", false, TaskCategory.ESTUDOS, TaskPriority.MEDIA),
            Task("Limpar a casa", false, TaskCategory.CASA, TaskPriority.BAIXA)
        )
    )
    val tasks: StateFlow<List<Task>> = _tasks

    private var lastDeletedTask: Task? = null

    private val _progress = MutableStateFlow(0f)
    val progress: StateFlow<Float> = _progress

    // Lê o tema do DataStore
    val themeFlow: Flow<Boolean> = DataStoreUtils.readTheme(context)
    private val _isDarkTheme = MutableStateFlow(false)
    val isDarkTheme: StateFlow<Boolean> = _isDarkTheme

    init {
        viewModelScope.launch {
            // Carrega as tarefas salvas do DataStore
            try {
                DataStoreUtils.readTasks(context).collect { savedTasks ->
                    if (savedTasks.isNotEmpty()) {
                        _tasks.value = DataStoreUtils.deserializeTasks(savedTasks)
                    }

                    // Coleta o tema salvo do DataStore
                    themeFlow.collect { savedTheme ->
                        _isDarkTheme.value = savedTheme
                    }
                }
            } catch (e: Exception) {
                // Logar erro ou tratar de alguma maneira
                e.printStackTrace()
            }

            updateProgress()
        }
    }

    fun addTask(task: Task, context: Context) {
        _tasks.value = _tasks.value + task
        saveTasks(context, _tasks.value) // Salva a lista atualizada no DataStore
        updateProgress()
    }

    fun removeTask(task: Task, context: Context) {
        lastDeletedTask = task
        _tasks.value = _tasks.value - task
        saveTasks(context, _tasks.value)
    }

    fun undoDelete(context: Context) {
        lastDeletedTask?.let {
            _tasks.value = _tasks.value + it
            lastDeletedTask = null
            saveTasks(context, _tasks.value)
        }
    }

    fun toggleTaskCompletion(task: Task, context: Context) {
        _tasks.value = _tasks.value.map {
            if (it == task) it.copy(isCompleted = !it.isCompleted) else it
        }
        saveTasks(context, _tasks.value)
        updateProgress()
    }

    private fun updateProgress() {
        val completed = _tasks.value.count { it.isCompleted }
        _progress.value = if (_tasks.value.isNotEmpty()) completed.toFloat() / _tasks.value.size else 0f
    }

    fun toggleTheme(context: Context) {
        viewModelScope.launch {
            val newTheme = !_isDarkTheme.value
            _isDarkTheme.value = newTheme
            DataStoreUtils.saveTheme(context, newTheme)
        }
    }

    private fun saveTasks(context: Context, tasks: List<Task>) {
        viewModelScope.launch {
            val serializedTasks = DataStoreUtils.serializeTasks(tasks)
            DataStoreUtils.saveTasks(context, serializedTasks) // Passa a lista serializada
        }
    }
}