package com.jennysival.nookapp.data.local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FeaturesModel(var name: String, var icon: Int) : Parcelable
