// SecondScreen.kt
package com.leo.projetocompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leo.projetocompose.ui.theme.ProjetoComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirdScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Third Screen") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Magenta,
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Third Screen!", color = Color.Black)
        }
    }
}

@Preview
@Composable
fun ThirdScreenPreview() {
    ProjetoComposeTheme {
        ThirdScreen()
    }
}
