package com.dam2_23_24.ejemplocorrutinas.home.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {

    private val _resultState = MutableLiveData<String>()
    val resultState: LiveData<String> = _resultState

    private val _callCount = MutableLiveData<Int>()

    private val _color = MutableLiveData<Boolean>()

    init {
        _callCount.value = 0
        _color.value = false
    }

    fun changeColor() {
        _color.value = _color.value?.let { !it }
    }

    fun fetchData() {
        _callCount.value = _callCount.value?.plus(1)
        //Nos permite crear una corrutina desde un ViewModel
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                delay(5000)
                "Respuesta de la API (${_callCount.value})"
            }
            _resultState.value = result
        }
    }

    fun getColor(): Color = if (_color.value == true) Color.Blue else Color.Red

}