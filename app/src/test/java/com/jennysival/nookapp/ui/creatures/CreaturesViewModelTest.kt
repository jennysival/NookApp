package com.jennysival.nookapp.ui.creatures

import androidx.lifecycle.Observer
import com.jennysival.nookapp.getOrAwaitValue
import com.jennysival.nookapp.testRulesCoroutinesLiveData
import com.jennysival.nookapp.ui.creatures.bugs.BugsUiModel
import com.jennysival.nookapp.ui.creatures.fishes.FishesUiModel
import com.jennysival.nookapp.ui.creatures.sea.SeaUiModel
import com.jennysival.nookapp.usecase.CreaturesUseCase
import com.jennysival.nookapp.utils.ViewState
import io.mockk.Awaits
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CreaturesViewModelTest {

    private val mockUseCase = mockk<CreaturesUseCase>()
    private lateinit var viewModel: CreaturesViewModel

    @get:Rule
    val rule = testRulesCoroutinesLiveData

    @MockK
    private var bugsListObserver: Observer<ViewState<List<BugsUiModel>>> = mockk(relaxed = true)

    @MockK
    private var fishesListObserver: Observer<ViewState<List<FishesUiModel>>> = mockk(relaxed = true)

    @MockK
    private var seaListObserver: Observer<ViewState<List<SeaUiModel>>> = mockk(relaxed = true)

    @MockK
    private var loadObserver: Observer<ViewState<Boolean>> = mockk(relaxed = true)

    private val bugsMock = BugsUiModel(
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

    private val fishMock = FishesUiModel(
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
        catchFish = true
    )

    private val seaMock = SeaUiModel(
        imageUrl = "",
        name = "",
        number = 1,
        rarity = "",
        renderUrl = "",
        sellNook = 50,
        shadowMovement = "",
        shadowSize = "",
        tankLength = 1,
        tankWidth = 2,
        totalCatch = 3,
        url = "",
        catchSea = true
    )

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        clearAllMocks()
        viewModel = CreaturesViewModel(mockUseCase)

    }

    @After
    fun tearDown() {
        viewModel.bugsListState.removeObserver(bugsListObserver)
        viewModel.fishesListState.removeObserver(fishesListObserver)
        viewModel.seaListState.removeObserver(seaListObserver)
        viewModel.loadState.removeObserver(loadObserver)
    }

    @Test
    fun `bugsListState should be Success when get bugs list from usecase`() {
        runBlocking {
            val listMock = listOf(bugsMock)

            coEvery { mockUseCase.getBugsFromDatabase() } returns ViewState.Success(listMock)
            viewModel.bugsListState.observeForever(bugsListObserver)

            viewModel.getBugsFromDatabase()
            delay(100)

            Assert.assertTrue(viewModel.bugsListState.getOrAwaitValue() is ViewState.Success)
            verify { bugsListObserver.onChanged(ViewState.Success(listMock)) }
        }
    }

    @Test
    fun `should throw exception when fail to get bugs list from usecase`() {
        runBlocking {
            coEvery { mockUseCase.getBugsFromDatabase() } throws Exception("")

            viewModel.getBugsFromDatabase()
            delay(100)

            coVerify { mockUseCase.getBugsFromDatabase() }
        }
    }

    @Test
    fun `fishesListState should be Success when get fishes list from usecase`() {
        runBlocking {
            val listMock = listOf(
                fishMock
            )

            coEvery { mockUseCase.getFishesFromDatabase() } returns ViewState.Success(listMock)
            viewModel.fishesListState.observeForever(fishesListObserver)

            viewModel.getFishesFromDatabase()
            delay(100)

            Assert.assertTrue(viewModel.fishesListState.getOrAwaitValue() is ViewState.Success)
            verify { fishesListObserver.onChanged(ViewState.Success(listMock)) }
        }
    }

    @Test
    fun `should throw exception when fail to get fishes list from usecase`() {
        runBlocking {
            coEvery { mockUseCase.getFishesFromDatabase() } throws Exception("")

            viewModel.getFishesFromDatabase()
            delay(100)

            coVerify { mockUseCase.getFishesFromDatabase() }
        }
    }

    @Test
    fun `seaListState should be Success when get sea list from usecase`() {
        runBlocking {
            val listMock = listOf(
                seaMock
            )

            coEvery { mockUseCase.getSeaFromDatabase() } returns ViewState.Success(listMock)
            viewModel.seaListState.observeForever(seaListObserver)

            viewModel.getSeaFromDatabase()
            delay(100)

            Assert.assertTrue(viewModel.seaListState.getOrAwaitValue() is ViewState.Success)
            verify { seaListObserver.onChanged(ViewState.Success(listMock)) }
        }
    }

    @Test
    fun `should throw exception when fail to get sea list from usecase`() {
        runBlocking {
            coEvery { mockUseCase.getFishesFromDatabase() } throws Exception("")

            viewModel.getFishesFromDatabase()
            delay(100)

            coVerify { mockUseCase.getFishesFromDatabase() }
        }
    }

    @Test
    fun `getBugsFromDatabase should update loadState`() {
        runBlocking {
            val listMock = listOf(bugsMock)
            coEvery { mockUseCase.getBugsFromDatabase() } returns ViewState.Success(listMock)
            viewModel.loadState.observeForever(loadObserver)

            viewModel.getBugsFromDatabase()

            coVerify { mockUseCase.getBugsFromDatabase() }
            verify { loadObserver.onChanged(ViewState.Loading(true)) }
            verify { loadObserver.onChanged(ViewState.Loading(false)) }
        }
    }

    @Test
    fun `getFishesFromDatabase should update loadState`() {
        runBlocking {
            val listMock = listOf(
                fishMock
            )
            coEvery { mockUseCase.getFishesFromDatabase() } returns ViewState.Success(listMock)
            viewModel.loadState.observeForever(loadObserver)

            viewModel.getFishesFromDatabase()

            coVerify { mockUseCase.getFishesFromDatabase() }
            verify { loadObserver.onChanged(ViewState.Loading(true)) }
            verify { loadObserver.onChanged(ViewState.Loading(false)) }
        }
    }

    @Test
    fun `getSeaFromDatabase should update loadState`() {
        runBlocking {
            val listMock = listOf(
                seaMock
            )
            coEvery { mockUseCase.getSeaFromDatabase() } returns ViewState.Success(listMock)
            viewModel.loadState.observeForever(loadObserver)

            viewModel.getSeaFromDatabase()

            coVerify { mockUseCase.getSeaFromDatabase() }
            verify { loadObserver.onChanged(ViewState.Loading(true)) }
            verify { loadObserver.onChanged(ViewState.Loading(false)) }
        }
    }

    @Test
    fun `updateCatchBug should set correct params`() {
        runBlocking {
            coEvery { mockUseCase.updateCatchBugs(bugsMock) } just Awaits

            viewModel.updateCatchBug(bugsMock)

            coVerify { mockUseCase.updateCatchBugs(bugsMock) }
        }
    }

    @Test
    fun `updateCatchBug should throw Exception when fail to update database`() {
        runBlocking {
            coEvery { mockUseCase.updateCatchBugs(bugsMock) } throws Exception("")

            viewModel.updateCatchBug(bugsMock)

            coVerify { mockUseCase.updateCatchBugs(bugsMock) }
        }
    }

    @Test
    fun `updateCatchFish should set correct params`() {
        runBlocking {
            coEvery { mockUseCase.updateCatchFish(fishMock) } just Awaits

            viewModel.updateCatchFish(fishMock)

            coVerify { mockUseCase.updateCatchFish(fishMock) }
        }
    }

    @Test
    fun `updateCatchFish should throw Exception when fail to update database`() {
        runBlocking {
            coEvery { mockUseCase.updateCatchFish(fishMock) } throws Exception("")

            viewModel.updateCatchFish(fishMock)

            coVerify { mockUseCase.updateCatchFish(fishMock) }
        }
    }

    @Test
    fun `updateCatchSea should set correct params`() {
        runBlocking {
            coEvery { mockUseCase.updateCatchSea(seaMock) } just Awaits

            viewModel.updateCatchSea(seaMock)

            coVerify { mockUseCase.updateCatchSea(seaMock) }
        }
    }

    @Test
    fun `updateCatchSea should throw Exception when fail to update database`() {
        runBlocking {
            coEvery { mockUseCase.updateCatchSea(seaMock) } throws Exception("")

            viewModel.updateCatchSea(seaMock)

            coVerify { mockUseCase.updateCatchSea(seaMock) }
        }
    }
}