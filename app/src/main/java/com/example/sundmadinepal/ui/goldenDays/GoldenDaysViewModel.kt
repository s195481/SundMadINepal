package com.example.sundmadinepal.ui.goldenDays

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sundmadinepal.model.model.GoldenDays
import kotlinx.coroutines.flow.MutableStateFlow

class GoldenDaysViewModel : ViewModel() {

    object DataProvider {
        val goldenDaysList = listOf(
            GoldenDays(
                "Maternity",
                "Maternity",
                ""
            ),
            GoldenDays(
                "0-6 Months",
                "0-6 Months",
                ""
            ),
            GoldenDays(
                "6-9 Months",
                "6-9 Months",
                ""
            ),
            GoldenDays(
                "9-12 Months",
                "9-12 Months",
                ""
            ),
            GoldenDays(
                "12-24 Months",
                "12-24 Months",
                ""
            ),
            GoldenDays(
                "Maternity",
                "Maternity",
                ""
            ),
        )
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text

    val listOfCurrencies = mutableListOf("EUR", "USD", "DKK")

    val listOfCryptos = MutableStateFlow(listOf("BTC", "ETH", "ADA"))

    fun addCurrency(currency: String) {
        listOfCurrencies.add(currency);
    }

    fun addCrypto(crypto: String) {
        listOfCryptos.value = listOfCryptos.value.plus(crypto)
    }
}