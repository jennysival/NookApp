package com.jennysival.nookapp.data.remote.bugs


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "bugs_table")
data class BugsResponseItem(
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
    @SerializedName("sell_flick")
    var sellFlick: Int,
    @SerializedName("sell_nook")
    var sellNook: Int,
    @SerializedName("tank_length")
    var tankLength: Int,
    @SerializedName("tank_width")
    var tankWidth: Int,
    @SerializedName("total_catch")
    var totalCatch: Int,
    @SerializedName("url")
    var url: String,

    var catchBug: Boolean = false
)