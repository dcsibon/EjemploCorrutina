package com.dam2_23_24.ejemplocorrutinas.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment

@Composable
fun Content(homeViewModel: HomeViewModel) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BotonColor(homeViewModel)
        Text(text = homeViewModel.resultState)
        Button(onClick = {
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