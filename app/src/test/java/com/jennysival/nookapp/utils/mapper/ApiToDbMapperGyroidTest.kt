package com.jennysival.nookapp.utils.mapper

import com.jennysival.nookapp.data.remote.gyroids.ApiGyroidsResponseItem
import com.jennysival.nookapp.data.remote.gyroids.Variation
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ApiToDbMapperGyroidTest {

    private lateinit var mapper: ApiToDbMapperGyroid

    @Before
    fun setup() {
        mapper = ApiToDbMapperGyroid()
    }

    @Test
    fun `mapApiToDbGyroid should correctly map ApiGyroidsResponseItem to DbGyroid`() {
        val apiGyroidMock = ApiGyroidsResponseItem(
            name = "name",
            variationTotal = 1,
            variations = listOf(
                Variation(
                    imageUrl = "url",
                    variation = "vari"
                )
            )
        )

        val result = mapper.mapApiToDbGyroid(apiGyroidMock)

        assertEquals(apiGyroidMock.name, result.name)
        assertEquals(apiGyroidMock.variationTotal, result.variationTotal)
    }

    @Test
    fun `mapApiToDbVariation should correctly map Variation to DbVariation`() {
        val gyroidIdMock: Long = 1
        val apiVariationMock = Variation(
            imageUrl = "url",
            variation = "vari"
        )

        val result = mapper.mapApiToDbVariation(gyroidIdMock, apiVariationMock)

        assertEquals(gyroidIdMock, result.gyroidId)
        assertEquals(apiVariationMock.imageUrl, result.imageUrl)
        assertEquals(apiVariationMock.variation, result.variationName)
    }
}