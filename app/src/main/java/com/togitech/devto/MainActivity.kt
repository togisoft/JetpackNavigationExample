package com.togitech.devto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.togitech.devto.navigation.Navigation
import com.togitech.devto.ui.theme.DevToTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevToTheme {
                Navigation()
            }
        }
    }
}
