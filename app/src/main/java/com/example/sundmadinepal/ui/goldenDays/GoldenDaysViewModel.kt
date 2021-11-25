package com.example.sundmadinepal.ui.goldenDays

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class GoldenDaysViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text

    // Delete all below
    val listOfCurrencies = mutableListOf("EUR", "USD", "DKK")

    val listOfCryptos = MutableStateFlow(listOf("BTC", "ETH", "ADA"))

    fun addCurrency(currency: String) {
        listOfCurrencies.add(currency);
    }

    fun addCrypto(crypto: String) {
        listOfCryptos.value = listOfCryptos.value.plus(crypto)
    }
}