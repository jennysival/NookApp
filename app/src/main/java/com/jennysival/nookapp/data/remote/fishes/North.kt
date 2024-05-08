package com.jennysival.nookapp.data.remote.fishes


import com.google.gson.annotations.SerializedName

data class North(
    @SerializedName("availability_array")
    var availabilityArray: List<AvailabilityArray>,
    @SerializedName("months")
    var months: String,
    @SerializedName("months_array")
    var monthsArray: List<Int>,
    @SerializedName("times_by_month")
    var timesByMonth: TimesByMonth
)