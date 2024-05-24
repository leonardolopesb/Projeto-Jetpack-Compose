package com.leo.projetocompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leo.projetocompose.ui.theme.HotPink
import com.leo.projetocompose.ui.theme.Magenta
import com.leo.projetocompose.ui.theme.ProjetoComposeTheme
import com.leo.projetocompose.ui.theme.Purple

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
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Column() {
                Column(
                    modifier = Modifier
                        .padding(all = 8.dp),
                    //verticalAlignment = Alignment.CenterVertically
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    //Spacer(modifier = Modifier.height(32.dp))

                    Image(
                        painter = painterResource(R.drawable.elana),
                        contentDescription = null,
                        modifier = Modifier
                            .size(288.dp)
                            .clip(CircleShape)
                            .border(1.44.dp, Color.Magenta, CircleShape)
                    )
                    //Spacer(modifier = Modifier.width(8.dp))
                    Spacer(modifier = Modifier.height(32.dp))

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Hello World!",
                            color =  MaterialTheme.colorScheme.secondary,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(horizontal = 8.dp)

                        )
                        Spacer(modifier = Modifier.height(4.dp))

                        Surface(shape = MaterialTheme.shapes.large, shadowElevation = 2.dp) {
                            Text(
                                text = "Elana Trindade",
                                color = MaterialTheme.colorScheme.primary,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(32.dp))

                        Switch(
                            checked = isDarkTheme,
                            onCheckedChange = onToggleDarkMode,
                            colors = SwitchDefaults.colors(
                                //Cor do botão ligado
                                checkedThumbColor = Magenta,
                                //Cor do background com o botão ligado
                                checkedTrackColor = Color.White.copy(alpha = 0.8f),
                                //Cor da borda com o botão ligado
                                checkedBorderColor = Magenta,
                                //????????
                                checkedIconColor = MaterialTheme.colorScheme.onSecondary,

                                //Cor do botão desligado
                                uncheckedThumbColor = Purple,
                                //Cor do background com o botão desligado
                                uncheckedTrackColor = Color.Black.copy(alpha = 0.2f),
                                //Cor da borda com o botão desligado
                                uncheckedBorderColor = Purple,
                                //????????
                                uncheckedIconColor = MaterialTheme.colorScheme.onSecondary
                            )
                        )
                    }
                }
            }
        }
    }

    @Preview(showBackground = false, uiMode = Configuration.UI_MODE_NIGHT_YES)
    @Composable
    fun PreviewPrimeiraTela() {
        ProjetoComposeTheme {
            PrimeiraTela(isDarkTheme = true, onToggleDarkMode = {})
        }
    }
}