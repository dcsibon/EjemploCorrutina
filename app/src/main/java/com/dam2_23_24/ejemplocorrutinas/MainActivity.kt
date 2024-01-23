package com.dam2_23_24.ejemplocorrutinas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.dam2_23_24.ejemplocorrutinas.home.ui.Content
import com.dam2_23_24.ejemplocorrutinas.home.ui.HomeViewModel
import com.dam2_23_24.ejemplocorrutinas.ui.theme.EjemploCorrutinasTheme

class MainActivity : ComponentActivity() {

    private val homeViewmodel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EjemploCorrutinasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Content(homeViewmodel)
                }
            }
        }
    }
}

