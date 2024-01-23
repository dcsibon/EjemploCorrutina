package com.dam2_23_24.ejemplocorrutinas.home.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    var resultState by mutableStateOf("")
    private var callCount by mutableIntStateOf(0)

    private var color by mutableStateOf(false)

    fun changeColor() {
        color = !color
    }

    fun getColor() = if (color) Color.Blue else Color.Red

    fun bloqueoApp() {
        Thread.sleep(5000)
        callCount = callCount.plus(1)
        resultState = "Respuesta de la API $callCount"
    }

    /* Con LiveData
    private val _resultState = MutableLiveData<String>()
    val resultState: LiveData<String> = _resultState

    private val _callCount = MutableLiveData<Int>()

    private val _color = MutableLiveData<Boolean>()
    val color: LiveData<Boolean> = _color

    init {
        _callCount.value = 0
    }

    fun bloqueoApp() {
        Thread.sleep(5000)
        _callCount.value = _callCount.value?.plus(1)
        _resultState.value = "Respuesta de la API ${_callCount.value}"
    }

    fun changeColor() {
        _color.value = _color.value?.let { !it }
    }
    */

}