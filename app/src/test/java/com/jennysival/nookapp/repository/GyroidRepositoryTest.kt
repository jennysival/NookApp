package com.jennysival.nookapp.repository

import com.jennysival.nookapp.data.local.gyroids.DbGyroid
import com.jennysival.nookapp.data.local.gyroids.DbVariation
import com.jennysival.nookapp.data.local.gyroids.GyroidDao
import com.jennysival.nookapp.data.local.gyroids.GyroidWithVariations
import com.jennysival.nookapp.data.remote.gyroids.ApiGyroidsResponseItem
import com.jennysival.nookapp.data.remote.gyroids.Variation
import com.jennysival.nookapp.ui.gyroids.BrewsterDialogues
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GyroidRepositoryTest {

    private lateinit var subjectMock: GyroidRepository
    private lateinit var subject: GyroidRepository

    private lateinit var gyroidDaoMock: GyroidDao

    private lateinit var apiGyroidListMock: List<ApiGyroidsResponseItem>
    private lateinit var databaseGyroidListMock: List<GyroidWithVariations>

    @Before
    fun setup() {
        gyroidDaoMock = mockk(relaxed = true)

        subjectMock = mockk(relaxed = true)
        subject = GyroidRepository(
            gyroidDao = gyroidDaoMock
        )

        apiGyroidListMock = createApiGyroidListMock()
        databaseGyroidListMock = createDatabasGyroidListMock()
    }

    @Test
    fun `when getBugsApi is called should return data from api`() {
        runTest {
            coEvery { subjectMock.getGyroidsFromApi() } returns apiGyroidListMock

            val result = subjectMock.getGyroidsFromApi()

            Assert.assertEquals(apiGyroidListMock, result)
        }
    }

    @Test
    fun `when getBugsDatabase is called should return data from dao`() {
        runTest {
            coEvery { gyroidDaoMock.getGyroidsWithVariations() } returns databaseGyroidListMock

            val result = subject.getGyroidListFromDatabase()

            Assert.assertEquals(databaseGyroidListMock, result)
            coVerify(exactly = 1) { gyroidDaoMock.getGyroidsWithVariations() }
        }
    }

    @Test
    fun `when getVariations is called should return data from dao`() {
        runTest {
            val gyroidId = databaseGyroidListMock[0].gyroid.gyroidId
            val variationsList = databaseGyroidListMock[0].variations

            coEvery { gyroidDaoMock.getVariationsForGyroid(gyroidId) } returns variationsList

            val result = subject.getVariations(gyroidId)

            Assert.assertEquals(variationsList, result)
            coVerify(exactly = 1) { gyroidDaoMock.getVariationsForGyroid(gyroidId) }
        }
    }

    @Test
    fun `when insertGyroidInDatabase is called should save data to dao`() {
        runTest {
            val gyroidMock = databaseGyroidListMock[0].gyroid
            coEvery { gyroidDaoMock.insertGyroid(gyroidMock) } returns gyroidMock.gyroidId

            subject.insertGyroidInDatabase(gyroidMock)

            coVerify(exactly = 1) { gyroidDaoMock.insertGyroid(gyroidMock) }
        }
    }

    @Test
    fun `when insertVariationInDatabase is called should save data to dao`() {
        runTest {
            val variationMock = databaseGyroidListMock[0].variations[0]
            coEvery { gyroidDaoMock.insertVariation(variationMock) } returns Unit

            subject.insertVariationInDatabase(variationMock)

            coVerify(exactly = 1) { gyroidDaoMock.insertVariation(variationMock) }
        }
    }

    @Test
    fun `when updateCatchBugs is called should update data to dao`() {
        runTest {
            val variationMock = databaseGyroidListMock[0].variations[0]
            coEvery { gyroidDaoMock.updateVariation(variationMock) } returns Unit

            subject.updateVariation(variationMock)

            coVerify(exactly = 1) { gyroidDaoMock.updateVariation(variationMock) }
        }
    }

    @Test
    fun `when getRandomDialogue is called should return one of the expected dialogues`() {
        val expectedDialogues = listOf(
            BrewsterDialogues.RANDOM_DIALOGUE_ONE,
            BrewsterDialogues.RANDOM_DIALOGUE_TWO,
            BrewsterDialogues.RANDOM_DIALOGUE_THREE,
            BrewsterDialogues.RANDOM_DIALOGUE_FOUR,
            BrewsterDialogues.RANDOM_DIALOGUE_FIVE
        )

        val result = subject.getRandomDialogue()

        assertTrue(expectedDialogues.contains(result))
    }

    private fun createApiGyroidListMock(): List<ApiGyroidsResponseItem> = listOf(
        ApiGyroidsResponseItem(
            name = "",
            variationTotal = 5,
            variations = listOf(
                Variation(
                    imageUrl = "",
                    variation = ""
                )
            )

        )
    )

    private fun createDatabasGyroidListMock(): List<GyroidWithVariations> = listOf(
        GyroidWithVariations(
            gyroid = DbGyroid(
                gyroidId = 1,
                name = "",
                variationTotal = 5,
                currentVariationId = 1,
            ),
            variations = listOf(
                DbVariation(
                    imageUrl = "",
                    variationName = "",
                    gyroidId = 2
                )
            )
        )
    )
}