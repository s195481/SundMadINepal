package com.example.sundmadinepal.ui.health

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HealthViewModel : ViewModel() {

    private val _childName = MutableLiveData<String>().apply {
        value = "This is the name"
    }
    private val _childWeight = MutableLiveData<String>().apply {
        value = "This is the weight"
    }
    private val _childHeight = MutableLiveData<String>().apply {
        value = "This is the height"
    }
    private val _childBirthdate = MutableLiveData<String>().apply {
        value = "This is the birthdate"
    }
    private val _childDiary = MutableLiveData<String>().apply {
        value = "This is the diary"
    }
    private val wah = ""

}