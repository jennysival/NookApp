package com.jennysival.nookapp.repository

import com.jennysival.nookapp.data.local.critter.BugsDao
import com.jennysival.nookapp.data.local.critter.FishesDao
import com.jennysival.nookapp.data.local.critter.SeaDao
import com.jennysival.nookapp.data.remote.bugs.BugsResponseItem
import com.jennysival.nookapp.data.remote.fishes.FishesResponseItem
import com.jennysival.nookapp.data.remote.sea.SeaResponseItem
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CreaturesRepositoryTest {

    private lateinit var subjectMock: CreaturesRepository
    private lateinit var subject: CreaturesRepository

    private lateinit var bugsDaoMock: BugsDao
    private lateinit var fishesDaoMock: FishesDao
    private lateinit var seaDaoMock: SeaDao

    private lateinit var bugsListMock: List<BugsResponseItem>
    private lateinit var seaListMock: List<SeaResponseItem>
    private lateinit var fishesListMock: List<FishesResponseItem>

    @Before
    fun setup() {
        bugsDaoMock = mockk(relaxed = true)
        fishesDaoMock = mockk(relaxed = true)
        seaDaoMock = mockk(relaxed = true)

        subjectMock = mockk(relaxed = true)
        subject = CreaturesRepository(
            bugsDao = bugsDaoMock,
            fishesDao = fishesDaoMock,
            seaDao = seaDaoMock
        )

        bugsListMock = createBugsListMock()
        seaListMock = createSeaListMock()
        fishesListMock = createFishesListMock()
    }

    @Test
    fun `when getBugsApi is called should return data from api`() {
        runTest {
            coEvery { subjectMock.getBugsApi() } returns bugsListMock

            val result = subjectMock.getBugsApi()

            Assert.assertEquals(bugsListMock, result)
        }
    }

    @Test
    fun `when getSeaApi is called should return data from api`() {
        runTest {
            coEvery { subjectMock.getSeaApi() } returns seaListMock

            val result = subjectMock.getSeaApi()

            Assert.assertEquals(seaListMock, result)
        }
    }

    @Test
    fun `when getFishesApi is called should return data from api`() {
        runTest {
            coEvery { subjectMock.getFishesApi() } returns fishesListMock

            val result = subjectMock.getFishesApi()

            Assert.assertEquals(fishesListMock, result)
        }
    }

    @Test
    fun `when insertBugsDatabase is called should save data to dao`() {
        runTest {
            coEvery { bugsDaoMock.insertAllBugs(bugsListMock) } returns Unit

            subject.insertBugsDatabase(bugsListMock)

            coVerify(exactly = 1) { bugsDaoMock.insertAllBugs(bugsListMock) }
        }
    }

    @Test
    fun `when insertSeaDatabase is called should save data to dao`() {
        runTest {
            coEvery { seaDaoMock.insertAllSea(seaListMock) } returns Unit

            subject.insertSeaDatabase(seaListMock)

            coVerify(exactly = 1) { seaDaoMock.insertAllSea(seaListMock) }
        }
    }

    @Test
    fun `when insertFishesDatabase is called should save data to dao`() {
        runTest {
            coEvery { fishesDaoMock.insertAllFishes(fishesListMock) } returns Unit

            subject.insertFishesDatabase(fishesListMock)

            coVerify(exactly = 1) { fishesDaoMock.insertAllFishes(fishesListMock) }
        }
    }

    @Test
    fun `when updateCatchBugs is called should update data to dao`() {
        runTest {
            coEvery { bugsDaoMock.updateBug(bugsListMock[0]) } returns Unit

            subject.updateCatchBugs(bugsListMock[0])

            coVerify(exactly = 1) { bugsDaoMock.updateBug(bugsListMock[0]) }
        }
    }

    @Test
    fun `when updateCatchFish is called should update data to dao`() {
        runTest {
            coEvery { fishesDaoMock.updateFish(fishesListMock[0]) } returns Unit

            subject.updateCatchFish(fishesListMock[0])

            coVerify(exactly = 1) { fishesDaoMock.updateFish(fishesListMock[0]) }
        }
    }

    @Test
    fun `when updateCatchSea is called should update data to dao`() {
        runTest {
            coEvery { seaDaoMock.updateSea(seaListMock[0]) } returns Unit

            subject.updateCatchSea(seaListMock[0])

            coVerify(exactly = 1) { seaDaoMock.updateSea(seaListMock[0]) }
        }
    }

    @Test
    fun `when getBugsDatabase is called should return data from dao`() {
        runTest {
            coEvery { bugsDaoMock.getAllBugs() } returns bugsListMock

            val result = subject.getBugsDatabase()

            Assert.assertEquals(bugsListMock, result)
            coVerify(exactly = 1) { bugsDaoMock.getAllBugs() }
        }
    }

    @Test
    fun `when getSeaDatabase is called should return data from dao`() {
        runTest {
            coEvery { seaDaoMock.getAllSea() } returns seaListMock

            val result = subject.getSeaDatabase()

            Assert.assertEquals(seaListMock, result)
            coVerify(exactly = 1) { seaDaoMock.getAllSea() }
        }
    }

    @Test
    fun `when getFishesDatabase is called should return data from dao`() {
        runTest {
            coEvery { fishesDaoMock.getAllFishes() } returns fishesListMock

            val result = subject.getFishesDatabase()

            Assert.assertEquals(fishesListMock, result)
            coVerify(exactly = 1) { fishesDaoMock.getAllFishes() }
        }
    }

    private fun createBugsListMock(): List<BugsResponseItem> = listOf(
        BugsResponseItem(
            imageUrl = "url",
            location = "brazil",
            name = "bug",
            number = 2,
            rarity = "rare",
            renderUrl = "urll",
            sellFlick = 50,
            sellNook = 20,
            tankLength = 1,
            tankWidth = 2,
            totalCatch = 5,
            url = "urlll"
        )
    )

    private fun createSeaListMock(): List<SeaResponseItem> = listOf(
        SeaResponseItem(
            imageUrl = "url",
            name = "",
            number = 5,
            rarity = "",
            renderUrl = "",
            sellNook = 20,
            shadowMovement = "fast",
            shadowSize = "large",
            tankLength = 2,
            tankWidth = 1,
            totalCatch = 2,
            url = "",
            catchSea = true,
        )
    )

    private fun createFishesListMock(): List<FishesResponseItem> = listOf(
        FishesResponseItem(
            imageUrl = "",
            location = "",
            name = "",
            number = 8,
            rarity = "",
            renderUrl = "",
            sellCj = 100,
            sellNook = 50,
            shadowSize = "",
            tankLength = 1,
            tankWidth = 2,
            totalCatch = 6,
            url = "",
            catchFish = true
        )
    )
}