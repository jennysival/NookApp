package com.jennysival.nookapp.ui.gyroids.model

data class UiVariation(
    var gyroidId: Long,
    var imageUrl: String,
    var variationName: String,
    var gotVariation: Boolean = false,
    var variationId: Int
)