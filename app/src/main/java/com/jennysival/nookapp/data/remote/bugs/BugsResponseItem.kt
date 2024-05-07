package com.jennysival.nookapp.data.remote.bugs


import com.google.gson.annotations.SerializedName

data class BugsResponseItem(
    @SerializedName("catchphrases")
    var catchphrases: List<String>,
    @SerializedName("image_url")
    var imageUrl: String,
    @SerializedName("location")
    var location: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("north")
    var north: North,
    @SerializedName("number")
    var number: Int,
    @SerializedName("rarity")
    var rarity: String,
    @SerializedName("render_url")
    var renderUrl: String,
    @SerializedName("sell_flick")
    var sellFlick: Int,
    @SerializedName("sell_nook")
    var sellNook: Int,
    @SerializedName("south")
    var south: South,
    @SerializedName("tank_length")
    var tankLength: Int,
    @SerializedName("tank_width")
    var tankWidth: Int,
    @SerializedName("total_catch")
    var totalCatch: Int,
    @SerializedName("url")
    var url: String
)