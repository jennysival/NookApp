package com.jennysival.nookapp.ui.creatures.fishes


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class FishesUiModel(
    var imageUrl: String,
    var location: String,
    var name: String,
    var number: Int,
    var rarity: String,
    var renderUrl: String,
    var sellCj: Int,
    var sellNook: Int,
    var shadowSize: String,
    var tankLength: Int,
    var tankWidth: Int,
    var totalCatch: Int,
    var url: String,
    var catchFish: Boolean = false
)