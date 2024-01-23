package com.dam2_23_24.ejemplocorrutinas.home.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
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

    private var callCount by mutableIntStateOf(0)

    private var color by mutableStateOf(false)

    fun changeColor() {
        color = !color
    }

    fun getColor() = if (color) Color.Blue else Color.Red

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
        callCount++
        val result = withContext(Dispatchers.IO) {
            delay(5000)
            "Respuesta de la API ($callCount)"
        }
        resultState = result
    }
}