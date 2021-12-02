package com.example.sundmadinepal.ui.health

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HealthViewModel : ViewModel() {

    private val _name = MutableLiveData<String>().apply {
        value = ""
    }
    val name: LiveData<String> = _name

    private val _birth = MutableLiveData<String>().apply {
        value = ""
    }
    val birth: LiveData<String> = _birth

    private val _height = MutableLiveData<String>().apply {
        value = ""
    }
    val height: LiveData<String> = _height

    private val _weight = MutableLiveData<String>().apply {
        value = ""
    }
    val weight: LiveData<String> = _weight

    private val _diary = MutableLiveData<String>().apply {
        value = ""
    }
    val diary: LiveData<String> = _diary

}