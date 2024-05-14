package com.jennysival.nookapp.data.local.gyroids

import com.jennysival.nookapp.data.remote.gyroids.ApiGyroidsResponseItem

class GyroidApiDbMapper {

    fun mapApiToDb(apiGyList: List<ApiGyroidsResponseItem>): List<GyroidsEntity> =
        apiGyList.map { apiResponse ->
            when (apiResponse.variationTotal) {
                1 -> {
                    GyroidsEntity(
                        name = apiResponse.name,
                        variationTotal = apiResponse.variationTotal,
                        oneVariationName = apiResponse.variations[0].variation,
                        oneVariationimageUrl = apiResponse.variations[0].imageUrl
                    )
                }
                2 -> {
                    GyroidsEntity(
                        name = apiResponse.name,
                        variationTotal = apiResponse.variationTotal,
                        oneVariationName = apiResponse.variations[0].variation,
                        oneVariationimageUrl = apiResponse.variations[0].imageUrl,
                        twoVariationName = apiResponse.variations[1].variation,
                        twoVariationimageUrl = apiResponse.variations[1].imageUrl
                    )
                }
                3 -> {
                    GyroidsEntity(
                        name = apiResponse.name,
                        variationTotal = apiResponse.variationTotal,
                        oneVariationName = apiResponse.variations[0].variation,
                        oneVariationimageUrl = apiResponse.variations[0].imageUrl,
                        twoVariationName = apiResponse.variations[1].variation,
                        twoVariationimageUrl = apiResponse.variations[1].imageUrl,
                        threeVariationName = apiResponse.variations[2].variation,
                        threeVariationimageUrl = apiResponse.variations[2].imageUrl
                    )
                }
                4 -> {
                    GyroidsEntity(
                        name = apiResponse.name,
                        variationTotal = apiResponse.variationTotal,
                        oneVariationName = apiResponse.variations[0].variation,
                        oneVariationimageUrl = apiResponse.variations[0].imageUrl,
                        twoVariationName = apiResponse.variations[1].variation,
                        twoVariationimageUrl = apiResponse.variations[1].imageUrl,
                        threeVariationName = apiResponse.variations[2].variation,
                        threeVariationimageUrl = apiResponse.variations[2].imageUrl,
                        fourVariationName = apiResponse.variations[3].variation,
                        fourVariationimageUrl = apiResponse.variations[3].imageUrl
                    )
                }
                5 -> {
                    GyroidsEntity(
                        name = apiResponse.name,
                        variationTotal = apiResponse.variationTotal,
                        oneVariationName = apiResponse.variations[0].variation,
                        oneVariationimageUrl = apiResponse.variations[0].imageUrl,
                        twoVariationName = apiResponse.variations[1].variation,
                        twoVariationimageUrl = apiResponse.variations[1].imageUrl,
                        threeVariationName = apiResponse.variations[2].variation,
                        threeVariationimageUrl = apiResponse.variations[2].imageUrl,
                        fourVariationName = apiResponse.variations[3].variation,
                        fourVariationimageUrl = apiResponse.variations[3].imageUrl,
                        fiveVariationName = apiResponse.variations[4].variation,
                        fiveVariationimageUrl = apiResponse.variations[4].imageUrl
                    )
                }
                6 -> {
                    GyroidsEntity(
                        name = apiResponse.name,
                        variationTotal = apiResponse.variationTotal,
                        oneVariationName = apiResponse.variations[0].variation,
                        oneVariationimageUrl = apiResponse.variations[0].imageUrl,
                        twoVariationName = apiResponse.variations[1].variation,
                        twoVariationimageUrl = apiResponse.variations[1].imageUrl,
                        threeVariationName = apiResponse.variations[2].variation,
                        threeVariationimageUrl = apiResponse.variations[2].imageUrl,
                        fourVariationName = apiResponse.variations[3].variation,
                        fourVariationimageUrl = apiResponse.variations[3].imageUrl,
                        fiveVariationName = apiResponse.variations[4].variation,
                        fiveVariationimageUrl = apiResponse.variations[4].imageUrl,
                        sixVariationName = apiResponse.variations[5].variation,
                        sixVariationimageUrl = apiResponse.variations[5].imageUrl
                    )
                }
                7 -> {
                    GyroidsEntity(
                        name = apiResponse.name,
                        variationTotal = apiResponse.variationTotal,
                        oneVariationName = apiResponse.variations[0].variation,
                        oneVariationimageUrl = apiResponse.variations[0].imageUrl,
                        twoVariationName = apiResponse.variations[1].variation,
                        twoVariationimageUrl = apiResponse.variations[1].imageUrl,
                        threeVariationName = apiResponse.variations[2].variation,
                        threeVariationimageUrl = apiResponse.variations[2].imageUrl,
                        fourVariationName = apiResponse.variations[3].variation,
                        fourVariationimageUrl = apiResponse.variations[3].imageUrl,
                        fiveVariationName = apiResponse.variations[4].variation,
                        fiveVariationimageUrl = apiResponse.variations[4].imageUrl,
                        sixVariationName = apiResponse.variations[5].variation,
                        sixVariationimageUrl = apiResponse.variations[5].imageUrl,
                        sevenVariationName = apiResponse.variations[6].variation,
                        sevenVariationimageUrl = apiResponse.variations[6].imageUrl
                    )
                }
                else -> {
                    GyroidsEntity(
                        name = apiResponse.name,
                        variationTotal = apiResponse.variationTotal
                    )
                }
            }
        }

}