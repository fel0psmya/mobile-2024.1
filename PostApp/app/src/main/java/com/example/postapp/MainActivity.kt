package com.example.postapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.postapp.ui.theme.PostAppTheme
import com.example.postapp.ui.theme.components.DrawerContent
import com.example.postapp.ui.theme.components.TopBar
import com.example.postapp.ui.theme.components.BottomNavBar
import com.example.postapp.ui.theme.screens.PostScreen
import com.example.postapp.ui.theme.screens.UserScreen
import com.example.postapp.viewmodel.PostViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val drawerState = rememberDrawerState(DrawerValue.Closed)
            val scope = rememberCoroutineScope()

            PostAppTheme {
                ModalNavigationDrawer(
                    drawerState = drawerState,
                    gesturesEnabled = true,
                    drawerContent = {
                        DrawerContent(navController) { scope.launch { drawerState.close() } }
                    },
                    content = {
                        Scaffold(
                            topBar = {
                                TopBar(
                                    onOpenDrawer = { scope.launch { drawerState.open() } }
                                )
                            },
                            bottomBar = { BottomNavBar(navController) }
                        ) { innerPadding ->
                            val postViewModel: PostViewModel = viewModel()
                            NavHost(
                                navController = navController,
                                startDestination = "users",
                                modifier = Modifier.padding(innerPadding)
                            ) {
                                composable("users") {
                                    UserScreen(postViewModel, navController)
                                }
                                composable("posts") {
                                    PostScreen(postViewModel, navController)
                                }
                            }
                        }
                    }
                )
            }
        }
    }
}