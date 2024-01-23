package com.dam2_23_24.ejemplocorrutinas.home.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    var resultState by mutableStateOf("")
        private set

    fun bloqueoApp() {
        Thread.sleep(5000)
        resultState = "Respuesta de la API"
    }

}