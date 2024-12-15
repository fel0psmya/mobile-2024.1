package com.example.outerwildsplanetapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.outerwildsplanetapp.navigation.NavGraph

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavGraph(
                onSettingsClick = {
                    // Action to Settings (can open a new screen or show a dialog)
                    showToast("Opening settings screen...")
                },
                onHelpClick = {
                    // Action to Help (can open a new screen or show a dialog)
                    showToast("Opening help screen...")
                }
            )
        }
    }
}