package com.dam2_23_24.ejemplocorrutinas.home.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {

    var resultState by mutableStateOf("")
        private set

    var isLoading by mutableStateOf(false)
        private set


    fun fetchData() {
        //Nos permite crear una corrutina desde un ViewModel
        viewModelScope.launch {
            try {
                isLoading = true
                llamarApi()
            } catch (e: Exception) {
                println("Error ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }

    //Solo funcionan dentro de una corrutina u otra función suspendida
    private suspend fun llamarApi() {
        val result = withContext(Dispatchers.IO) {
            delay(5000)
            "Respuesta de la API"
        }
        resultState = result
    }

    /*
    fun fetchData() {
        //Nos permite crear una corrutina desde un ViewModel
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                delay(5000)
                "Respuesta de la API"
            }
            resultState = result
        }
    }

    fun bloqueoApp() {
        Thread.sleep(5000)
        resultState = "Respuesta de la API"
    }
    */
}