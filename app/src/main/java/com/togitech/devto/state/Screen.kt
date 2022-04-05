package com.togitech.devto.state

sealed class Screen(val route: String) {
    object HomeScreen : Screen(route ="home")
    object DetailScreen : Screen(route = "detail")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
