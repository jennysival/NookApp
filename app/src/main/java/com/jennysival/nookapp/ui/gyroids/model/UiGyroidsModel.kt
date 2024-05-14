package com.jennysival.nookapp.ui.gyroids.model

data class UiGyroidsModel(
    var id: Int = 0,
    var name: String,
    var variationTotal: Int,
    var variations: List<UiVariation>,
    var isSelected: Boolean = false
)