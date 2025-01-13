package com.example.taskmanagerapp.ui.components

import kotlinx.serialization.Serializable

@Serializable
enum class TaskPriority { BAIXA, MEDIA, ALTA }

@Serializable
enum class TaskCategory { TRABALHO, CASA, ESTUDOS }

@Serializable
data class Task(
    val name: String,
    val isCompleted: Boolean = false,
    val category: TaskCategory = TaskCategory.CASA,
    val priority: TaskPriority = TaskPriority.MEDIA
)