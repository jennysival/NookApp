package com.jennysival.nookapp.data.remote.sea


import com.google.gson.annotations.SerializedName

data class South(
    @SerializedName("availability_array")
    var availabilityArray: List<AvailabilityArray>,
    @SerializedName("months")
    var months: String,
    @SerializedName("months_array")
    var monthsArray: List<Int>,
    @SerializedName("times_by_month")
    var timesByMonth: TimesByMonth
)