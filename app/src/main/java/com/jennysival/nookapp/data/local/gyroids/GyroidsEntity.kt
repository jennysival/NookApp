package com.jennysival.nookapp.data.local.gyroids

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gyroids_table")
data class GyroidsEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String,
    var variationTotal: Int,

    var oneVariationName: String = "",
    var oneVariationimageUrl: String = "",
    var oneGotVariation: Boolean = false,

    var twoVariationName: String = "",
    var twoVariationimageUrl: String = "",
    var twoGotVariation: Boolean = false,

    var threeVariationName: String = "",
    var threeVariationimageUrl: String = "",
    var threeGotVariation: Boolean = false,

    var fourVariationName: String = "",
    var fourVariationimageUrl: String = "",
    var fourGotVariation: Boolean = false,

    var fiveVariationName: String = "",
    var fiveVariationimageUrl: String = "",
    var fiveGotVariation: Boolean = false,

    var sixVariationName: String = "",
    var sixVariationimageUrl: String = "",
    var sixGotVariation: Boolean = false,

    var sevenVariationName: String = "",
    var sevenVariationimageUrl: String = "",
    var sevenGotVariation: Boolean = false
)