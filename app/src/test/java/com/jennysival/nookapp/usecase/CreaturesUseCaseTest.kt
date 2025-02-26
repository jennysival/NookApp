package com.jennysival.nookapp.usecase

import android.database.sqlite.SQLiteConstraintException
import com.jennysival.nookapp.data.local.critter.BugsDao
import com.jennysival.nookapp.data.local.critter.FishesDao
import com.jennysival.nookapp.data.local.critter.SeaDao
import com.jennysival.nookapp.data.remote.bugs.BugsResponseItem
import com.jennysival.nookapp.data.remote.fishes.FishesResponseItem
import com.jennysival.nookapp.data.remote.sea.SeaResponseItem
import com.jennysival.nookapp.repository.CreaturesRepository
import com.jennysival.nookapp.ui.creatures.bugs.BugsUiModel
import com.jennysival.nookapp.ui.creatures.fishes.FishesUiModel
import com.jennysival.nookapp.ui.creatures.sea.SeaUiModel
import com.jennysival.nookapp.utils.ViewState
import com.jennysival.nookapp.utils.mapper.CreaturesMapper
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CreaturesUseCaseTest {

    private lateinit var subject: CreaturesUseCase
    private lateinit var creaturesMapperMock: CreaturesMapper
    private lateinit var creaturesRepositoryMock: CreaturesRepository

    private lateinit var bugsDaoMock: BugsDao
    private lateinit var fishesDaoMock: FishesDao
    private lateinit var seaDaoMock: SeaDao

    @Before
    fun setup() {
        bugsDaoMock = mockk(relaxed = true)
        fishesDaoMock = mockk(relaxed = true)
        seaDaoMock = mockk(relaxed = true)

        creaturesMapperMock = mockk(relaxed = true)
        creaturesRepositoryMock = mockk(relaxed = true)
        subject = CreaturesUseCase(
            bugsDao = bugsDaoMock,
            fishesDao = fishesDaoMock,
            seaDao = seaDaoMock,
            creaturesMapper = creaturesMapperMock,
            creaturesRepository = creaturesRepositoryMock
        )
    }

    @Test
    fun `when updateCatchSea call is successful should return success ViewState`() {
        runTest {
            val seaMock = createSeaUiModelMock()
            val result = subject.updateCatchSea(catchSea = seaMock)

            Assert.assertEquals(ViewState.Success(seaMock), result)
        }
    }

    @Test
    fun `when updateCatchSea is called and throws SQLiteConstraintException should return error ViewState`() {
        runTest {
            val exception = SQLiteConstraintException()
            val seaMock = createSeaUiModelMock()
            val apiSeaMock = createApiSeaModelMock()

            coEvery { creaturesMapperMock.mapSingleSeaUiToApi(seaMock) } returns apiSeaMock
            coEvery { creaturesRepositoryMock.updateCatchSea(apiSeaMock) } throws exception
            val result = subject.updateCatchSea(catchSea = seaMock)

            Assert.assertTrue(result is ViewState.Error)
        }
    }

    @Test
    fun `when getSeaFromDatabase call is successful should return success ViewState`() {
        runTest {
            val seaMock = createSeaUiModelMock()
            val apiSeaMock = createApiSeaModelMock()

            coEvery { creaturesRepositoryMock.getSeaDatabase() } returns listOf(apiSeaMock)
            coEvery { creaturesMapperMock.mapSeaApiToUi(listOf(apiSeaMock)) } returns listOf(seaMock)
            val result = subject.getSeaFromDatabase()

            Assert.assertEquals(ViewState.Success(listOf(seaMock)), result)
        }
    }

    @Test
    fun `when getSeaFromDatabase is called and throws SQLiteConstraintException should return error ViewState`() {
        runTest {
            val exception = SQLiteConstraintException()

            coEvery { creaturesRepositoryMock.getSeaDatabase() } throws exception
            val result = subject.getSeaFromDatabase()

            Assert.assertTrue(result is ViewState.Error)
        }
    }

    @Test
    fun `when updateCatchBugs call is successful should return success ViewState`() {
        runTest {
            val bugMock = createBugUiModelMock()
            val result = subject.updateCatchBugs(catchBug = bugMock)

            Assert.assertEquals(ViewState.Success(bugMock), result)
        }
    }

    @Test
    fun `when updateCatchBugs is called and throws SQLiteConstraintException should return error ViewState`() {
        runTest {
            val exception = SQLiteConstraintException()
            val bugMock = createBugUiModelMock()
            val apiBugMock = createApiBugModelMock()

            coEvery { creaturesMapperMock.mapSingleBugUiToApi(bugMock) } returns apiBugMock
            coEvery { creaturesRepositoryMock.updateCatchBugs(apiBugMock) } throws exception
            val result = subject.updateCatchBugs(catchBug = bugMock)

            Assert.assertTrue(result is ViewState.Error)
        }
    }

    @Test
    fun `when getBugsFromDatabase call is successful should return success ViewState`() {
        runTest {
            val bugMock = createBugUiModelMock()
            val apiBugMock = createApiBugModelMock()

            coEvery { creaturesRepositoryMock.getBugsDatabase() } returns listOf(apiBugMock)
            coEvery { creaturesMapperMock.mapBugsApiToUi(listOf(apiBugMock)) } returns listOf(bugMock)
            val result = subject.getBugsFromDatabase()

            Assert.assertEquals(ViewState.Success(listOf(bugMock)), result)
        }
    }

    @Test
    fun `when getBugsFromDatabase is called and throws SQLiteConstraintException should return error ViewState`() {
        runTest {
            val exception = SQLiteConstraintException()

            coEvery { creaturesRepositoryMock.getBugsDatabase() } throws exception
            val result = subject.getBugsFromDatabase()

            Assert.assertTrue(result is ViewState.Error)
        }
    }

    @Test
    fun `when updateCatchFish call is successful should return success ViewState`() {
        runTest {
            val fishMock = createFishUiModelMock()
            val result = subject.updateCatchFish(catchFish = fishMock)

            Assert.assertEquals(ViewState.Success(fishMock), result)
        }
    }

    @Test
    fun `when updateCatchFish is called and throws SQLiteConstraintException should return error ViewState`() {
        runTest {
            val exception = SQLiteConstraintException()
            val fishMock = createFishUiModelMock()
            val apiFishMock = createApiFishModelMock()

            coEvery { creaturesMapperMock.mapSingleFishUiToApi(fishMock) } returns apiFishMock
            coEvery { creaturesRepositoryMock.updateCatchFish(apiFishMock) } throws exception
            val result = subject.updateCatchFish(catchFish = fishMock)

            Assert.assertTrue(result is ViewState.Error)
        }
    }

    @Test
    fun `when getFishesFromDatabase call is successful should return success ViewState`() {
        runTest {
            val fishMock = createFishUiModelMock()
            val apiFishMock = createApiFishModelMock()

            coEvery { creaturesRepositoryMock.getFishesDatabase() } returns listOf(apiFishMock)
            coEvery { creaturesMapperMock.mapFishesApiToUi(listOf(apiFishMock)) } returns listOf(fishMock)
            val result = subject.getFishesFromDatabase()

            Assert.assertEquals(ViewState.Success(listOf(fishMock)), result)
        }
    }

    @Test
    fun `when getFishesFromDatabase is called and throws SQLiteConstraintException should return error ViewState`() {
        runTest {
            val exception = SQLiteConstraintException()

            coEvery { creaturesRepositoryMock.getFishesDatabase() } throws exception
            val result = subject.getFishesFromDatabase()

            Assert.assertTrue(result is ViewState.Error)
        }
    }

    private fun createSeaUiModelMock(): SeaUiModel = SeaUiModel(
        imageUrl = "",
        name = "",
        number = 1,
        rarity = "",
        renderUrl = "",
        sellNook = 20,
        shadowMovement = "",
        shadowSize = "",
        tankLength = 1,
        tankWidth = 2,
        totalCatch = 3,
        url = "",
        catchSea = false
    )

    private fun createApiSeaModelMock(): SeaResponseItem = SeaResponseItem(
        imageUrl = "",
        name = "",
        number = 1,
        rarity = "",
        renderUrl = "",
        sellNook = 20,
        shadowMovement = "",
        shadowSize = "",
        tankLength = 1,
        tankWidth = 2,
        totalCatch = 3,
        url = "",
        catchSea = false
    )

    private fun createBugUiModelMock(): BugsUiModel = BugsUiModel(
        imageUrl = "",
        location = "",
        name = "",
        number = 1,
        rarity = "",
        renderUrl = "",
        sellFlick = 50,
        sellNook = 20,
        tankLength = 1,
        tankWidth = 2,
        totalCatch = 3,
        url = "",
        catchBug = true
    )

    private fun createApiBugModelMock(): BugsResponseItem = BugsResponseItem(
        imageUrl = "",
        location = "",
        name = "",
        number = 1,
        rarity = "",
        renderUrl = "",
        sellFlick = 50,
        sellNook = 20,
        tankLength = 1,
        tankWidth = 2,
        totalCatch = 3,
        url = "",
        catchBug = true
    )

    private fun createFishUiModelMock(): FishesUiModel = FishesUiModel(
        imageUrl = "",
        location = "",
        name = "",
        number = 1,
        rarity = "",
        renderUrl = "",
        sellCj = 50,
        sellNook = 20,
        shadowSize = "",
        tankLength = 1,
        tankWidth = 2,
        totalCatch = 3,
        url = "",
        catchFish = false
    )

    private fun createApiFishModelMock(): FishesResponseItem = FishesResponseItem(
        imageUrl = "",
        location = "",
        name = "",
        number = 1,
        rarity = "",
        renderUrl = "",
        sellCj = 50,
        sellNook = 20,
        shadowSize = "",
        tankLength = 1,
        tankWidth = 2,
        totalCatch = 3,
        url = "",
        catchFish = false
    )
}