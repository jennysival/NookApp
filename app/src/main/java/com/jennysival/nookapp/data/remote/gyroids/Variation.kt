package com.jennysival.nookapp.data.remote.gyroids


import com.google.gson.annotations.SerializedName

data class Variation(
    @SerializedName("image_url")
    var imageUrl: String,
    @SerializedName("variation")
    var variation: String
)