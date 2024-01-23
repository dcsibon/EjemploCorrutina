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
        BotonColor(homeViewModel)
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
fun BotonColor(homeViewModel: HomeViewModel) {

    Button(
        onClick = { homeViewModel.changeColor() },
        colors = ButtonDefaults.buttonColors(containerColor = homeViewModel.getColor()),
    ) {
        Text(text = "Cambiar color")
    }

}