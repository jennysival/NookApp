package com.jennysival.nookapp.ui.creatures.sea


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class SeaUiModel(
    var imageUrl: String,
    var name: String,
    var number: Int,
    var rarity: String,
    var renderUrl: String,
    var sellNook: Int,
    var shadowMovement: String,
    var shadowSize: String,
    var tankLength: Int,
    var tankWidth: Int,
    var totalCatch: Int,
    var url: String,
    var catchSea: Boolean = false
)