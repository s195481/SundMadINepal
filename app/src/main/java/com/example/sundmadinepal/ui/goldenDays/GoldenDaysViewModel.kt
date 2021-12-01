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
        )
    }
}