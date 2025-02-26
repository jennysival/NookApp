package com.jennysival.nookapp.usecase

import android.database.sqlite.SQLiteConstraintException
import com.jennysival.nookapp.data.local.gyroids.DbGyroid
import com.jennysival.nookapp.data.local.gyroids.DbVariation
import com.jennysival.nookapp.data.local.gyroids.GyroidDao
import com.jennysival.nookapp.data.local.gyroids.GyroidWithVariations
import com.jennysival.nookapp.repository.GyroidRepository
import com.jennysival.nookapp.ui.gyroids.model.UiGyroidsModel
import com.jennysival.nookapp.ui.gyroids.model.UiVariation
import com.jennysival.nookapp.utils.ViewState
import com.jennysival.nookapp.utils.mapper.ApiToDbMapperGyroid
import com.jennysival.nookapp.utils.mapper.UiGyroidMapper
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GyroidUseCaseTest {

    private lateinit var subject: GyroidUseCase
    private lateinit var uiGyroidMapperMock: UiGyroidMapper
    private lateinit var apiGyroidMapperMock: ApiToDbMapperGyroid
    private lateinit var gyroidsRepositoryMock: GyroidRepository

    private lateinit var gyroidDaoMock: GyroidDao

    @Before
    fun setup() {
        gyroidDaoMock = mockk(relaxed = true)

        uiGyroidMapperMock = mockk(relaxed = true)
        apiGyroidMapperMock = mockk(relaxed = true)
        gyroidsRepositoryMock = mockk(relaxed = true)
        subject = GyroidUseCase(
            gyroidDao = gyroidDaoMock,
            gyroidUiMapper = uiGyroidMapperMock,
            gyroidApiMapper = apiGyroidMapperMock,
            gyroidRepository = gyroidsRepositoryMock
        )
    }

    @Test
    fun `when getGyroidListFromDatabase call is successful should return success ViewState`() {
        runTest {
            val gyroidMock = createGyroidUiModelMock()
            val dbGyroidMock = createDbGyroidModelMock()

            coEvery { gyroidsRepositoryMock.getGyroidListFromDatabase() } returns listOf(dbGyroidMock)
            coEvery { uiGyroidMapperMock.mapDbToUi(listOf(dbGyroidMock)) } returns listOf(gyroidMock)
            val result = subject.getGyroidListFromDatabase()

            Assert.assertEquals(ViewState.Success(listOf(gyroidMock)), result)
        }
    }

    @Test
    fun `when getGyroidListFromDatabase is called and throws SQLiteConstraintException should return error ViewState`() {
        runTest {
            val exception = SQLiteConstraintException()

            coEvery { gyroidsRepositoryMock.getGyroidListFromDatabase() } throws exception
            val result = subject.getGyroidListFromDatabase()

            Assert.assertTrue(result is ViewState.Error)
        }
    }

    @Test
    fun `when getVariationsFromDatabase call is successful should return success ViewState`() {
        runTest {
            val gyroidMock = createGyroidUiModelMock()
            val dbVariationsListMock = createDbVariationsList()
            val uiVariantionsListMock = createUiVariationsList()

            coEvery { gyroidsRepositoryMock.getVariations(gyroidId = gyroidMock.gyroidId) } returns dbVariationsListMock
            coEvery { uiGyroidMapperMock.mapVariationDbToUi(dbVariationsListMock) } returns uiVariantionsListMock

            val result = subject.getVariationsFromDatabase(gyroidId = gyroidMock.gyroidId)

            Assert.assertEquals(ViewState.Success(uiVariantionsListMock), result)
        }
    }

    @Test
    fun `when getVariationsFromDatabase is called and throws SQLiteConstraintException should return error ViewState`() {
        runTest {
            val gyroidMock = createGyroidUiModelMock()
            val exception = SQLiteConstraintException()

            coEvery { gyroidsRepositoryMock.getVariations(gyroidId = gyroidMock.gyroidId) } throws exception
            val result = subject.getVariationsFromDatabase(gyroidId = gyroidMock.gyroidId)

            Assert.assertTrue(result is ViewState.Error)
        }
    }

    @Test
    fun `when updateGyroidCurrentVariation call is successful should call updateVariation`() {
        runTest {
            val uiVariationMock = createUiVariationsList()[0]
            val dbVariationMock = createDbVariationsList()[0]

            coEvery { uiGyroidMapperMock.mapUiToDbVariation(uiVariationMock) } returns dbVariationMock
            coEvery { gyroidsRepositoryMock.updateVariation(dbVariationMock) } returns Unit

            subject.updateGyroidCurrentVariation(uiVariationMock)

            coVerify { gyroidsRepositoryMock.updateVariation(dbVariationMock) }
        }
    }

    @Test
    fun `when updateGyroidCurrentVariation is called and throws SQLiteConstraintException should return error ViewState`() {
        runTest {
            val exceptionMessage = "Test SQLiteConstraintException"
            val exception = SQLiteConstraintException(exceptionMessage)
            val uiVariationMock = createUiVariationsList()[0]
            val dbVariationMock = createDbVariationsList()[0]

            coEvery { uiGyroidMapperMock.mapUiToDbVariation(uiVariationMock) } returns dbVariationMock
            coEvery { gyroidsRepositoryMock.updateVariation(dbVariationMock) } throws exception

            subject.updateGyroidCurrentVariation(uiVariationMock)

            coVerify { gyroidsRepositoryMock.updateVariation(dbVariationMock) }
        }
    }

    @Test
    fun `when getRandomDialogue is called should return the repository's dialogue`() {
        val expectedDialogue = "Test Dialogue"
        every { gyroidsRepositoryMock.getRandomDialogue() } returns expectedDialogue

        val actualDialogue = subject.getRandomDialogue()

        Assert.assertEquals(expectedDialogue, actualDialogue)
        verify { gyroidsRepositoryMock.getRandomDialogue() }
    }

    private fun createGyroidUiModelMock(): UiGyroidsModel = UiGyroidsModel(
        gyroidId = 1,
        name = "",
        variationTotal = 2,
        variations = createUiVariationsList(),
        isSelected = true
    )

    private fun createDbGyroidModelMock(): GyroidWithVariations = GyroidWithVariations(
        gyroid = DbGyroid(
            gyroidId = 1,
            name = "",
            variationTotal = 2,
            currentVariationId = 1
        ),
        variations = createDbVariationsList()
    )

    private fun createUiVariationsList(): List<UiVariation> = listOf(UiVariation(
        gyroidId = 1,
        imageUrl = "",
        variationName = "",
        gotVariation = true,
        variationId = 1
    ))

    private fun createDbVariationsList(): List<DbVariation> = listOf(
        DbVariation(
            variationId = 1,
            gyroidId = 1,
            imageUrl = "",
            variationName = "",
            gotVariation = true
        )
    )

}