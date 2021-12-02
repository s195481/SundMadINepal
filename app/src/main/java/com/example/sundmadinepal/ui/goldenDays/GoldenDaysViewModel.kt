package com.example.sundmadinepal.ui.goldenDays

import androidx.lifecycle.ViewModel
import com.example.sundmadinepal.model.model.GoldenDays

// TODO Delete class and remove dependencies
class GoldenDaysViewModel : ViewModel() {

    object DataProvider {
        val goldenDaysList = listOf(
            GoldenDays(
                "Maternity",
                "Maternity",
                "maternity"
            ),
            GoldenDays(
                "0-6 Months",
                "0-6 Months",
                "zerotosixmonths"
            ),
            GoldenDays(
                "6-9 Months",
                "6-9 Months",
                "sixtoninemonths"
            ),
            GoldenDays(
                "9-12 Months",
                "9-12 Months",
                "ninetotwelvemonths"
            ),
            GoldenDays(
                "12-24 Months",
                "12-24 Months",
                "twelvetotwentyfourmonths"
            ),
        )
    }
}