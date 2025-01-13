package com.example.taskmanagerapp.ui.components

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

val Context.dataStore by preferencesDataStore(name = "user_prefs")

object DataStoreUtils {
    private val TASKS_KEY = stringPreferencesKey("tasks")
    private val THEME_KEY = booleanPreferencesKey("is_dark_theme")

    // Salva as tarefas no DataStore
    suspend fun saveTasks(context: Context, tasks: String) {
        try {
            context.dataStore.edit { prefs ->
                prefs[TASKS_KEY] = tasks
            }
        } catch (e: Exception) {
            // Log de erro ou tratamento personalizado
            println("Erro ao salvar as tarefas: ${e.message}")
        }
    }

    // Lê tarefas do DataStore
    fun readTasks(context: Context): Flow<String> = context.dataStore.data.map { prefs ->
        prefs[TASKS_KEY] ?: ""
    }

    // Serializa uma lista de tarefas para string JSON
    fun serializeTasks(tasks: List<Task>): String {
        return try {
            Json.encodeToString(tasks)
        } catch (e: Exception) {
            // Log de erro ou tratamento personalizado
            println("Erro na serialização das tarefas: ${e.message}")
            ""
        }
    }

    // Desserializa uma string JSON para uma lista de tarefas
    fun deserializeTasks(serializedTasks: String): List<Task> {
        return try {
            if (serializedTasks.isNotEmpty()) {
                Json.decodeFromString(serializedTasks)
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            // Log de erro ou tratamento personalizado
            println("Erro na desserialização das tarefas: ${e.message}")
            emptyList()
        }
    }

    // Salva o tema no DataStore
    suspend fun saveTheme(context: Context, isDark: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[THEME_KEY] = isDark
        }
    }

    // Lê o tema no DataStore
    fun readTheme(context: Context): Flow<Boolean> = context.dataStore.data.map { prefs ->
        prefs[THEME_KEY] ?: false
    }
}


