package com.jennysival.nookapp.data.local.gyroids

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DbGyroid(
    @PrimaryKey(autoGenerate = true)
    var gyroidId: Long = 0,
    var name: String,
    var variationTotal: Int,
    var currentVariationId: Int = 0
)