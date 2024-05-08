package com.jennysival.nookapp.data.remote.fishes


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "fishes_table")
data class FishesResponseItem(
    @SerializedName("image_url")
    var imageUrl: String,
    @SerializedName("location")
    var location: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("number")
    @PrimaryKey(autoGenerate = false)
    var number: Int,
    @SerializedName("rarity")
    var rarity: String,
    @SerializedName("render_url")
    var renderUrl: String,
    @SerializedName("sell_cj")
    var sellCj: Int,
    @SerializedName("sell_nook")
    var sellNook: Int,
    @SerializedName("shadow_size")
    var shadowSize: String,
    @SerializedName("tank_length")
    var tankLength: Int,
    @SerializedName("tank_width")
    var tankWidth: Int,
    @SerializedName("total_catch")
    var totalCatch: Int,
    @SerializedName("url")
    var url: String,

    var catchFish: Boolean = false
)