package com.empresa.calculadera

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val result = MutableLiveData("")
    val resultView: LiveData<String> = result
    private var calcValue: Double = 0.0
    private var operation: String = ""


    fun updateDisplay(numbers: String) {
        result.value += numbers
    }

    fun operation(operation: String) {
        if (calcValue == 0.0) {
            calcValue = (result.value)?.toDouble()!!
            result.value = ""
        }
        this.operation = operation
    }

    fun result() {

        val value: Double? = ((result.value)?.toDouble())

        when (operation) {
            "*" -> result.value = (calcValue * value!!).toString()
            "/" -> result.value = (calcValue / value!!).toString()
            "-" -> result.value = (calcValue - value!!).toString()
            "+" -> result.value = (calcValue + value!!).toString()
        }

        calcValue = 0.0

    }

    fun erase() {
        result.value = ""
        calcValue = 0.0
        operation = ""
    }


}