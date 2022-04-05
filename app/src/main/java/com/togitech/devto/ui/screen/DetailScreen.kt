package com.togitech.devto.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailScreen(name: String?, surname: String?, navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Detail Screen") }, navigationIcon = {
                IconButton(
                    onClick = {
                        navController.popBackStack()
                    }) {
                    Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = "posStackBack")
                }
            })
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
                Text(text = "Hello $name $surname", fontWeight = FontWeight.Bold)
            }
        }
    }
}