package com.jennysival.nookapp.ui.gyroids.model

data class UiGyroidsModel(
    var gyroidId: Long,
    var name: String,
    var variationTotal: Int,
    var variations: List<UiVariation>,
    var isSelected: Boolean = false
)