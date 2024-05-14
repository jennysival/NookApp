package com.jennysival.nookapp.data.remote.gyroids


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Variation(
    @SerializedName("image_url")
    var imageUrl: String,
    @SerializedName("variation")
    var variation: String,
    var gotVariation: Boolean = false
)