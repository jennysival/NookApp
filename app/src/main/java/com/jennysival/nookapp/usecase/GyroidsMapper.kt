package com.jennysival.nookapp.usecase

import com.jennysival.nookapp.data.local.gyroids.GyroidsEntity
import com.jennysival.nookapp.ui.gyroids.model.UiGyroidsModel
import com.jennysival.nookapp.ui.gyroids.model.UiVariation

class GyroidsMapper {

    fun mapDbToUi(dbList: List<GyroidsEntity>): List<UiGyroidsModel> =
        dbList.map { gyroid ->
            UiGyroidsModel(
                id = gyroid.id,
                name = gyroid.name,
                variationTotal = gyroid.variationTotal,
                variations = setUpVariationsList(gyroid)
            )
        }

    private fun setUpVariationsList(gyroid: GyroidsEntity): List<UiVariation> {
        val uiList = mutableListOf<UiVariation>()
        uiList.add(
            UiVariation(
                imageUrl = gyroid.oneVariationimageUrl,
                variation = gyroid.oneVariationName,
                gotVariation = gyroid.oneGotVariation
            )
        )
        uiList.add(
            UiVariation(
                imageUrl = gyroid.twoVariationimageUrl,
                variation = gyroid.twoVariationName,
                gotVariation = gyroid.twoGotVariation
            )
        )
        uiList.add(
            UiVariation(
                imageUrl = gyroid.threeVariationimageUrl,
                variation = gyroid.threeVariationName,
                gotVariation = gyroid.threeGotVariation
            )
        )
        uiList.add(
            UiVariation(
                imageUrl = gyroid.fourVariationimageUrl,
                variation = gyroid.fourVariationName,
                gotVariation = gyroid.fourGotVariation
            )
        )
        uiList.add(
            UiVariation(
                imageUrl = gyroid.fiveVariationimageUrl,
                variation = gyroid.fiveVariationName,
                gotVariation = gyroid.fiveGotVariation
            )
        )
        uiList.add(
            UiVariation(
                imageUrl = gyroid.sixVariationimageUrl,
                variation = gyroid.sixVariationName,
                gotVariation = gyroid.sixGotVariation
            )
        )
        uiList.add(
            UiVariation(
                imageUrl = gyroid.sevenVariationimageUrl,
                variation = gyroid.sevenVariationName,
                gotVariation = gyroid.sevenGotVariation
            )
        )
        return uiList
    }

    fun mapUiToDb(uiList: List<UiGyroidsModel>): List<GyroidsEntity> =
        uiList.map { gyroid ->
            mapSingleUiToDb(gyroid)
        }

    fun mapSingleUiToDb(gyroid: UiGyroidsModel): GyroidsEntity =
        when (gyroid.variationTotal) {
            1 -> {
                GyroidsEntity(
                    id = gyroid.id,
                    name = gyroid.name,
                    variationTotal = gyroid.variationTotal,
                    oneVariationName = gyroid.variations[0].variation,
                    oneVariationimageUrl = gyroid.variations[0].imageUrl,
                    oneGotVariation = gyroid.variations[0].gotVariation
                )
            }

            2 -> {
                GyroidsEntity(
                    id = gyroid.id,
                    name = gyroid.name,
                    variationTotal = gyroid.variationTotal,
                    oneVariationName = gyroid.variations[0].variation,
                    oneVariationimageUrl = gyroid.variations[0].imageUrl,
                    oneGotVariation = gyroid.variations[0].gotVariation,
                    twoVariationName = gyroid.variations[1].variation,
                    twoVariationimageUrl = gyroid.variations[1].imageUrl,
                    twoGotVariation = gyroid.variations[1].gotVariation
                )
            }

            3 -> {
                GyroidsEntity(
                    id = gyroid.id,
                    name = gyroid.name,
                    variationTotal = gyroid.variationTotal,
                    oneVariationName = gyroid.variations[0].variation,
                    oneVariationimageUrl = gyroid.variations[0].imageUrl,
                    oneGotVariation = gyroid.variations[0].gotVariation,
                    twoVariationName = gyroid.variations[1].variation,
                    twoVariationimageUrl = gyroid.variations[1].imageUrl,
                    twoGotVariation = gyroid.variations[1].gotVariation,
                    threeVariationName = gyroid.variations[2].variation,
                    threeVariationimageUrl = gyroid.variations[2].imageUrl,
                    threeGotVariation = gyroid.variations[2].gotVariation
                )
            }

            4 -> {
                GyroidsEntity(
                    id = gyroid.id,
                    name = gyroid.name,
                    variationTotal = gyroid.variationTotal,
                    oneVariationName = gyroid.variations[0].variation,
                    oneVariationimageUrl = gyroid.variations[0].imageUrl,
                    oneGotVariation = gyroid.variations[0].gotVariation,
                    twoVariationName = gyroid.variations[1].variation,
                    twoVariationimageUrl = gyroid.variations[1].imageUrl,
                    twoGotVariation = gyroid.variations[1].gotVariation,
                    threeVariationName = gyroid.variations[2].variation,
                    threeVariationimageUrl = gyroid.variations[2].imageUrl,
                    threeGotVariation = gyroid.variations[2].gotVariation,
                    fourVariationName = gyroid.variations[3].variation,
                    fourVariationimageUrl = gyroid.variations[3].imageUrl,
                    fourGotVariation = gyroid.variations[3].gotVariation
                )
            }

            5 -> {
                GyroidsEntity(
                    id = gyroid.id,
                    name = gyroid.name,
                    variationTotal = gyroid.variationTotal,
                    oneVariationName = gyroid.variations[0].variation,
                    oneVariationimageUrl = gyroid.variations[0].imageUrl,
                    oneGotVariation = gyroid.variations[0].gotVariation,
                    twoVariationName = gyroid.variations[1].variation,
                    twoVariationimageUrl = gyroid.variations[1].imageUrl,
                    twoGotVariation = gyroid.variations[1].gotVariation,
                    threeVariationName = gyroid.variations[2].variation,
                    threeVariationimageUrl = gyroid.variations[2].imageUrl,
                    threeGotVariation = gyroid.variations[2].gotVariation,
                    fourVariationName = gyroid.variations[3].variation,
                    fourVariationimageUrl = gyroid.variations[3].imageUrl,
                    fourGotVariation = gyroid.variations[3].gotVariation,
                    fiveVariationName = gyroid.variations[4].variation,
                    fiveVariationimageUrl = gyroid.variations[4].imageUrl,
                    fiveGotVariation = gyroid.variations[4].gotVariation
                )
            }

            6 -> {
                GyroidsEntity(
                    id = gyroid.id,
                    name = gyroid.name,
                    variationTotal = gyroid.variationTotal,
                    oneVariationName = gyroid.variations[0].variation,
                    oneVariationimageUrl = gyroid.variations[0].imageUrl,
                    oneGotVariation = gyroid.variations[0].gotVariation,
                    twoVariationName = gyroid.variations[1].variation,
                    twoVariationimageUrl = gyroid.variations[1].imageUrl,
                    twoGotVariation = gyroid.variations[1].gotVariation,
                    threeVariationName = gyroid.variations[2].variation,
                    threeVariationimageUrl = gyroid.variations[2].imageUrl,
                    threeGotVariation = gyroid.variations[2].gotVariation,
                    fourVariationName = gyroid.variations[3].variation,
                    fourVariationimageUrl = gyroid.variations[3].imageUrl,
                    fourGotVariation = gyroid.variations[3].gotVariation,
                    fiveVariationName = gyroid.variations[4].variation,
                    fiveVariationimageUrl = gyroid.variations[4].imageUrl,
                    fiveGotVariation = gyroid.variations[4].gotVariation,
                    sixVariationName = gyroid.variations[5].variation,
                    sixVariationimageUrl = gyroid.variations[5].imageUrl,
                    sixGotVariation = gyroid.variations[5].gotVariation
                )
            }

            7 -> {
                GyroidsEntity(
                    id = gyroid.id,
                    name = gyroid.name,
                    variationTotal = gyroid.variationTotal,
                    oneVariationName = gyroid.variations[0].variation,
                    oneVariationimageUrl = gyroid.variations[0].imageUrl,
                    oneGotVariation = gyroid.variations[0].gotVariation,
                    twoVariationName = gyroid.variations[1].variation,
                    twoVariationimageUrl = gyroid.variations[1].imageUrl,
                    twoGotVariation = gyroid.variations[1].gotVariation,
                    threeVariationName = gyroid.variations[2].variation,
                    threeVariationimageUrl = gyroid.variations[2].imageUrl,
                    threeGotVariation = gyroid.variations[2].gotVariation,
                    fourVariationName = gyroid.variations[3].variation,
                    fourVariationimageUrl = gyroid.variations[3].imageUrl,
                    fourGotVariation = gyroid.variations[3].gotVariation,
                    fiveVariationName = gyroid.variations[4].variation,
                    fiveVariationimageUrl = gyroid.variations[4].imageUrl,
                    fiveGotVariation = gyroid.variations[4].gotVariation,
                    sixVariationName = gyroid.variations[5].variation,
                    sixVariationimageUrl = gyroid.variations[5].imageUrl,
                    sixGotVariation = gyroid.variations[5].gotVariation,
                    sevenVariationName = gyroid.variations[6].variation,
                    sevenVariationimageUrl = gyroid.variations[6].imageUrl,
                    sevenGotVariation = gyroid.variations[6].gotVariation
                )
            }

            else -> {
                GyroidsEntity(
                    id = gyroid.id,
                    name = gyroid.name,
                    variationTotal = gyroid.variationTotal
                )
            }
        }
}