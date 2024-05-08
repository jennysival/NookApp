package com.jennysival.nookapp.data.remote.sea


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "sea_table")
data class SeaResponseItem(
    @SerializedName("image_url")
    var imageUrl: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("number")
    @PrimaryKey(autoGenerate = false)
    var number: Int,
    @SerializedName("rarity")
    var rarity: String,
    @SerializedName("render_url")
    var renderUrl: String,
    @SerializedName("sell_nook")
    var sellNook: Int,
    @SerializedName("shadow_movement")
    var shadowMovement: String,
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

    var catchSea: Boolean = false
)