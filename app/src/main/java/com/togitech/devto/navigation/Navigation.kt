package com.togitech.devto.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.togitech.devto.state.Screen
import com.togitech.devto.ui.screen.DetailScreen
import com.togitech.devto.ui.screen.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.DetailScreen.route + "/{name}/{surname}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    nullable = false
                },
                navArgument("surname") {
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) { entry ->
            DetailScreen(
                name = entry.arguments?.getString("name"),
                surname = entry.arguments?.getString("surname"),
                navController = navController
            )
        }
    }
}