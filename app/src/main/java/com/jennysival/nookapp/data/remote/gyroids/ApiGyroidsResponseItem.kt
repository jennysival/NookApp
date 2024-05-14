package com.jennysival.nookapp.data.remote.gyroids

import com.google.gson.annotations.SerializedName

data class ApiGyroidsResponseItem(
    @SerializedName("name")
    var name: String,
    @SerializedName("variation_total")
    var variationTotal: Int,
    @SerializedName("variations")
    var variations: List<Variation>
)