package com.jennysival.nookapp.utils.mapper

import com.jennysival.nookapp.data.local.gyroids.DbGyroid
import com.jennysival.nookapp.data.local.gyroids.DbVariation
import com.jennysival.nookapp.data.remote.gyroids.ApiGyroidsResponseItem
import com.jennysival.nookapp.data.remote.gyroids.Variation

class ApiToDbMapperGyroid {

    fun mapApiToDbGyroid(apiGyroid: ApiGyroidsResponseItem): DbGyroid =
        DbGyroid(name = apiGyroid.name, variationTotal = apiGyroid.variationTotal)

    fun mapApiToDbVariation(gyroidId: Long, apiVariation: Variation): DbVariation =
        DbVariation(
            gyroidId = gyroidId,
            imageUrl = apiVariation.imageUrl,
            variationName = apiVariation.variation
        )

}