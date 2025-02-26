package com.jennysival.nookapp.utils.mapper

import com.jennysival.nookapp.data.local.gyroids.DbVariation
import com.jennysival.nookapp.data.local.gyroids.GyroidWithVariations
import com.jennysival.nookapp.utils.mocks.databaseGyroidsListMock
import com.jennysival.nookapp.utils.mocks.databaseVariationList
import com.jennysival.nookapp.utils.mocks.uiVariationMock
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class UiGyroidMapperTest {

    private lateinit var mapper: UiGyroidMapper

    @Before
    fun setup() {
        mapper = UiGyroidMapper()
    }

    @Test
    fun `mapDbToUi should correctly map list of GyroidWithVariations to list of UiGyroidsModel`() {
        val uiList = mapper.mapDbToUi(databaseGyroidsListMock)

        assertEquals(databaseGyroidsListMock.size, uiList.size)

        for (i in databaseGyroidsListMock.indices) {
            val dbGyroid = databaseGyroidsListMock[i].gyroid
            val uiGyroid = uiList[i]

            assertEquals(dbGyroid.gyroidId, uiGyroid.gyroidId)
            assertEquals(dbGyroid.name, uiGyroid.name)
            assertEquals(dbGyroid.variationTotal, uiGyroid.variationTotal)
            assertEquals(databaseGyroidsListMock[i].variations.size, uiGyroid.variations.size)

            for (j in databaseGyroidsListMock[i].variations.indices) {
                val dbVariation = databaseGyroidsListMock[i].variations[j]
                val uiVariation = uiGyroid.variations[j]
                assertEquals(dbVariation.variationId, uiVariation.variationId)
                assertEquals(dbVariation.gyroidId, uiVariation.gyroidId)
                assertEquals(dbVariation.imageUrl, uiVariation.imageUrl)
                assertEquals(dbVariation.variationName, uiVariation.variationName)
                assertEquals(dbVariation.gotVariation, uiVariation.gotVariation)
            }
        }
    }

    @Test
    fun `mapVariationDbToUi should correctly map list of DbVariation to list of UiVariation`() {
        val uiList = mapper.mapVariationDbToUi(databaseVariationList)

        assertEquals(databaseVariationList.size, uiList.size)

        for (i in databaseVariationList.indices) {
            val dbVariation = databaseVariationList[i]
            val uiVariation = uiList[i]

            assertEquals(dbVariation.variationId, uiVariation.variationId)
            assertEquals(dbVariation.gyroidId, uiVariation.gyroidId)
            assertEquals(dbVariation.imageUrl, uiVariation.imageUrl)
            assertEquals(dbVariation.variationName, uiVariation.variationName)
            assertEquals(dbVariation.gotVariation, uiVariation.gotVariation)
        }
    }

    @Test
    fun `mapUiToDbVariation should correctly map UiVariation to DbVariation`() {
        val dbVariation = mapper.mapUiToDbVariation(uiVariationMock)

        assertEquals(uiVariationMock.variationId, dbVariation.variationId)
        assertEquals(uiVariationMock.gyroidId, dbVariation.gyroidId)
        assertEquals(uiVariationMock.imageUrl, dbVariation.imageUrl)
        assertEquals(uiVariationMock.variationName, dbVariation.variationName)
        assertEquals(uiVariationMock.gotVariation, dbVariation.gotVariation)
    }

    @Test
    fun `mapDbToUi should handle empty list`() {
        val databaseEmptyList = emptyList<GyroidWithVariations>()

        val uiList = mapper.mapDbToUi(databaseEmptyList)

        assertEquals(0, uiList.size)
    }

    @Test
    fun `mapVariationDbToUi should handle empty list`() {
        val databaseEmptyList = emptyList<DbVariation>()

        val uiList = mapper.mapVariationDbToUi(databaseEmptyList)

        assertEquals(0, uiList.size)
    }
}