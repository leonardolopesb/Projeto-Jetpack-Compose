package com.leo.projetocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leo.projetocompose.ui.theme.ProjetoComposeTheme

class MainActivity() : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isDarkTheme = remember {
                mutableStateOf(true)
            }
            ProjetoComposeTheme {
                DarkThemeApp(darkMode = isDarkTheme.value) {
                    isDarkTheme.value = it
                }
            }
        }
    }

    @Composable
    fun DarkThemeApp(darkMode: Boolean, onToggle: (Boolean) -> Unit) {
        val colorScheme = if (darkMode) darkColorScheme() else lightColorScheme()

        MaterialTheme(colorScheme = colorScheme) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                PrimeiraTela(isDarkTheme = darkMode, onToggleDarkMode = onToggle)
            }
        }
    }

    @Composable
    fun PrimeiraTela(isDarkTheme: Boolean, onToggleDarkMode: (Boolean) -> Unit){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            //verticalAlignment = Alignment.CenterVertically
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Spacer(modifier = Modifier.height(64.dp))

            Image(
                painter = painterResource(R.drawable.eu),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .aspectRatio(0.8f)
                    .clip(RoundedCornerShape(50))
            )
            Spacer(modifier = Modifier.height(48.dp))

            Column {
                Text(
                    text = "Hello World!",
                    color = Color.Green,
                    modifier = Modifier.padding(horizontal = 8.dp)

                )
                Text(
                    text = "Leonardo Lopes",
                    color = Color.Yellow,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Switch(checked = isDarkTheme, onCheckedChange = onToggleDarkMode)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewPrimeiraTela() {
        ProjetoComposeTheme {
            PrimeiraTela(isDarkTheme = true, onToggleDarkMode = {})
        }
    }
}