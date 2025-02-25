package com.jennysival.nookapp.utils.mapper

import com.jennysival.nookapp.data.local.gyroids.DbVariation
import com.jennysival.nookapp.data.local.gyroids.GyroidWithVariations
import com.jennysival.nookapp.ui.gyroids.model.UiGyroidsModel
import com.jennysival.nookapp.ui.gyroids.model.UiVariation

class UiGyroidMapper {
    fun mapDbToUi(dbList: List<GyroidWithVariations>): List<UiGyroidsModel> =
        dbList.map {
            UiGyroidsModel(
                gyroidId = it.gyroid.gyroidId,
                name = it.gyroid.name,
                variationTotal = it.gyroid.variationTotal,
                variations = mapVariationDbToUi(it.variations),
            )
        }

    fun mapVariationDbToUi(dbList: List<DbVariation>): List<UiVariation> =
        dbList.map {
            UiVariation(
                gyroidId = it.gyroidId,
                imageUrl = it.imageUrl,
                variationName = it.variationName,
                gotVariation = it.gotVariation,
                variationId = it.variationId
            )
        }

    fun mapUiToDbVariation(uiVariation: UiVariation): DbVariation =
        DbVariation(
            variationId = uiVariation.variationId,
            gyroidId = uiVariation.gyroidId,
            imageUrl = uiVariation.imageUrl,
            variationName = uiVariation.variationName,
            gotVariation = uiVariation.gotVariation
        )
}