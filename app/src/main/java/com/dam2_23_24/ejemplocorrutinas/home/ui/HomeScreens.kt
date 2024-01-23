package com.dam2_23_24.ejemplocorrutinas.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun Content(homeViewModel: HomeViewModel) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BotonColor()
        if (homeViewModel.isLoading) {
            CircularProgressIndicator()
        } else {
            Text(text = homeViewModel.resultState)
        }
        Button(onClick = {
            //mainViewModel.bloqueoApp()
            homeViewModel.fetchData()
        }) {
            Text("Llamar API")
        }
    }
}

@Composable
fun BotonColor() {

    var color by remember { mutableStateOf(false) }

    Button(
        onClick = { color = !color },
        colors = ButtonDefaults.buttonColors(containerColor = if (color) Color.Blue else Color.Red),
    ) {
        Text(text = "Cambiar color")
    }

}