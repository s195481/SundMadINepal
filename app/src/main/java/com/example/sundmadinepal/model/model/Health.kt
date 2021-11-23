package com.example.sundmadinepal.model.model

import java.util.*

data class Health(
    var child_id: Int,
    var child_name: String,
    val child_weight: Int,
    val child_height: Int,
    val child_birthdate: Date,
    val child_diary: String
)