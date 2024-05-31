package com.leo.projetocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leo.projetocompose.ui.theme.ProjetoComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetoComposeTheme {
                AppNavigation()
            }
        }
    }

    @Composable
    fun AppNavigation() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "first_screen") {
            composable("first_screen") { PrimeiraTela(navController) }
            composable("second_screen") { SecondScreen(navController) }
            composable("third_screen") { ThirdScreen()}
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun PrimeiraTela(navController: NavHostController) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("My Random App") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Blue,
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
                Text("Hello, this is a random thing!", color = Color.Black)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { navController.navigate("second_screen") }) {
                    Text("Click Me")
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PrimeiraTelaPreview() {
        ProjetoComposeTheme {
            PrimeiraTela(rememberNavController())
        }
    }
}
