package com.jennysival.nookapp.utils.mocks

import com.jennysival.nookapp.data.local.gyroids.DbGyroid
import com.jennysival.nookapp.data.local.gyroids.DbVariation
import com.jennysival.nookapp.data.local.gyroids.GyroidWithVariations
import com.jennysival.nookapp.ui.gyroids.model.UiVariation

val databaseVariationsMock1 = listOf(
    DbVariation(
        variationId = 1,
        gyroidId = 1,
        imageUrl = "url1",
        variationName = "name1",
        gotVariation = true
    ),
    DbVariation(
        variationId = 2,
        gyroidId = 1,
        imageUrl = "url2",
        variationName = "name2",
        gotVariation = false
    )
)

val databaseVariationsMock2 = listOf(
    DbVariation(
        variationId = 3,
        gyroidId = 2,
        imageUrl = "url3",
        variationName = "name3",
        gotVariation = true
    )
)

val databaseGyroidsListMock = listOf(
    GyroidWithVariations(
        DbGyroid(
            gyroidId = 1,
            name = "Gyroid1",
            variationTotal = 2,
            currentVariationId = 1
        ), databaseVariationsMock1
    ),
    GyroidWithVariations(
        DbGyroid(
            gyroidId = 2,
            name = "Gyroid2",
            variationTotal = 1,
            currentVariationId = 3
        ), databaseVariationsMock2
    )
)

val databaseVariationList = listOf(
    DbVariation(
        variationId = 1,
        gyroidId = 1,
        imageUrl = "url1",
        variationName = "name1",
        gotVariation = true
    ),
    DbVariation(
        variationId = 2,
        gyroidId = 1,
        imageUrl = "url2",
        variationName = "name2",
        gotVariation = false
    ),
    DbVariation(
        variationId = 3,
        gyroidId = 2,
        imageUrl = "url3",
        variationName = "name3",
        gotVariation = true
    )
)

val uiVariationMock = UiVariation(
    variationId = 1,
    gyroidId = 1,
    imageUrl = "url1",
    variationName = "name1",
    gotVariation = true
)