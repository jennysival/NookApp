package com.jennysival.nookapp.data.remote.sea


import com.google.gson.annotations.SerializedName

data class AvailabilityArray(
    @SerializedName("months")
    var months: String,
    @SerializedName("time")
    var time: String
)