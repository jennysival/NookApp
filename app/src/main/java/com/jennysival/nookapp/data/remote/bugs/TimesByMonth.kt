package com.jennysival.nookapp.data.remote.bugs


import com.google.gson.annotations.SerializedName

data class TimesByMonth(
    @SerializedName("1")
    var x1: String,
    @SerializedName("10")
    var x10: String,
    @SerializedName("11")
    var x11: String,
    @SerializedName("12")
    var x12: String,
    @SerializedName("2")
    var x2: String,
    @SerializedName("3")
    var x3: String,
    @SerializedName("4")
    var x4: String,
    @SerializedName("5")
    var x5: String,
    @SerializedName("6")
    var x6: String,
    @SerializedName("7")
    var x7: String,
    @SerializedName("8")
    var x8: String,
    @SerializedName("9")
    var x9: String
)