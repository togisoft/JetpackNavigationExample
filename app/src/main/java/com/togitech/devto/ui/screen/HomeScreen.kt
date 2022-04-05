package com.togitech.devto.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.togitech.devto.state.Screen

@Composable
fun HomeScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Home Screen") })
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = name,
                    label = { Text(text = "Name") },
                    onValueChange = { name = it },
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                OutlinedTextField(
                    value = surname,
                    label = { Text(text = "Surname") },
                    onValueChange = { surname = it },
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                Button(onClick = {
                    if (name.isNotEmpty()) {
                        navController.navigate(Screen.DetailScreen.withArgs(name, surname))
                    } else {
                        Toast.makeText(context, "Fill in the required fields.", Toast.LENGTH_SHORT)
                            .show()
                    }
                }) {
                    Text(text = "Send Detail Screen")
                }
            }
        }
    }
}
