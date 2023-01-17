package com.empresa.calculadera

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlanetsViewModel : ViewModel() {

    private val mutableList = MutableLiveData(mutableListOf<String>())
    val list: LiveData<MutableList<String>> = mutableList

    fun add(planet: String) {
        if (planet.isNotBlank())
            mutableList.value = mutableList.value.also { it?.add(planet) }
    }
}