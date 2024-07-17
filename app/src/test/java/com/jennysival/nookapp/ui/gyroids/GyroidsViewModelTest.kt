package com.jennysival.nookapp.ui.gyroids

import androidx.lifecycle.Observer
import com.jennysival.nookapp.getOrAwaitValue
import com.jennysival.nookapp.testRulesCoroutinesLiveData
import com.jennysival.nookapp.ui.gyroids.model.UiGyroidsModel
import com.jennysival.nookapp.ui.gyroids.model.UiVariation
import com.jennysival.nookapp.usecase.GyroidUseCase
import com.jennysival.nookapp.utils.ViewState
import io.mockk.MockKAnnotations
import io.mockk.Runs
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
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

class GyroidsViewModelTest {

    private val mockUseCase = mockk<GyroidUseCase>()
    private lateinit var viewModel: GyroidsViewModel

    @get:Rule
    val rule = testRulesCoroutinesLiveData

    @MockK
    private var listObserver: Observer<ViewState<List<UiGyroidsModel>>> = mockk(relaxed = true)

    @MockK
    private var variationsObserver: Observer<ViewState<List<UiVariation>>> = mockk(relaxed = true)

    @MockK
    private var loadObserver: Observer<ViewState<Boolean>> = mockk(relaxed = true)

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        clearAllMocks()
        viewModel = GyroidsViewModel(mockUseCase)

    }

    @After
    fun tearDown() {
        viewModel.gyroidsListState.removeObserver(listObserver)
        viewModel.loadState.removeObserver(loadObserver)
    }

    @Test
    fun `gyroidsListState sould be Success when get list from usecase`() {
        runBlocking {
            //arrange
            val listMock = listOf(
                UiGyroidsModel(
                    gyroidId = 1,
                    name = "",
                    variationTotal = 1,
                    variations = listOf()
                )
            )

            coEvery { mockUseCase.getGyroidListFromDatabase() } returns ViewState.Success(listMock)

            viewModel.gyroidsListState.observeForever(listObserver)

            //act
            viewModel.getGyroidsFromDatabase()
            delay(100)

            //assert
            Assert.assertTrue(viewModel.gyroidsListState.getOrAwaitValue() is ViewState.Success)
            verify { listObserver.onChanged(ViewState.Success(listMock)) }
        }

    }

    @Test
    fun `should throw exception when fail to get list from usecase`() {
        runBlocking {
            //arrange
            coEvery { mockUseCase.getGyroidListFromDatabase() } throws Exception("")

            //act
            viewModel.getGyroidsFromDatabase()
            delay(100)

            //assert
            coVerify { mockUseCase.getGyroidListFromDatabase() }
        }

    }

    @Test
    fun `getGyroidsFromDatabase should update loadState`() {
        runBlocking {
            //arrange
            val listMock = listOf(
                UiGyroidsModel(
                    gyroidId = 1,
                    name = "",
                    variationTotal = 1,
                    variations = listOf()
                )
            )
            coEvery { mockUseCase.getGyroidListFromDatabase() } returns ViewState.Success(listMock)
            viewModel.loadState.observeForever(loadObserver)

            //act
            viewModel.getGyroidsFromDatabase()

            //assert
            coVerify { mockUseCase.getGyroidListFromDatabase() }
            verify { loadObserver.onChanged(ViewState.Loading(true)) }
            verify { loadObserver.onChanged(ViewState.Loading(false)) }
        }
    }

    @Test
    fun `getVariations should set Success ViewState when got list from database`() {
        runBlocking {
            //arrange
            val variationListMock = listOf(
                UiVariation(
                    gyroidId = 1L,
                    imageUrl = "",
                    variationId = 11,
                    variationName = ""
                )
            )
            coEvery { mockUseCase.getVariationsFromDatabase(1L) } returns ViewState.Success(
                variationListMock
            )
            viewModel.variationsListState.observeForever(variationsObserver)

            //act
            viewModel.getVariations(1L)

            //assert
            coVerify { mockUseCase.getVariationsFromDatabase(1L) }
            verify { variationsObserver.onChanged(ViewState.Success(variationListMock)) }
            Assert.assertTrue(viewModel.variationsListState.getOrAwaitValue() is ViewState.Success)
        }
    }

    @Test
    fun `getVariations should throw Exception when fail to get list from database`() {
        runBlocking {
            //arrange
            coEvery { mockUseCase.getVariationsFromDatabase(1L) } throws Exception("")

            //act
            viewModel.getVariations(1L)

            //assert
            coVerify { mockUseCase.getVariationsFromDatabase(1L) }
        }
    }

    @Test
    fun `getVariations should update loadState`() {
        runBlocking {
            //arrange
            val variationListMock = listOf(
                UiVariation(
                    gyroidId = 1L,
                    imageUrl = "",
                    variationId = 11,
                    variationName = ""
                )
            )
            coEvery { mockUseCase.getVariationsFromDatabase(1L) } returns ViewState.Success(
                variationListMock
            )
            viewModel.loadState.observeForever(loadObserver)

            //act
            viewModel.getVariations(1L)

            //assert
            coVerify { mockUseCase.getVariationsFromDatabase(1L) }
            verify { loadObserver.onChanged(ViewState.Loading(true)) }
            verify { loadObserver.onChanged(ViewState.Loading(false)) }
        }
    }

    @Test
    fun `updateGyroidCurrentVariation should set correct params`() {
        runBlocking {
            //arrange
            val variationMock = UiVariation(
                gyroidId = 1L,
                imageUrl = "",
                variationId = 11,
                variationName = ""
            )

            coEvery { mockUseCase.updateGyroidCurrentVariation(variationMock) } just Runs

            //act
            viewModel.updateGyroidCurrentVariation(variationMock)

            //assert
            coVerify { mockUseCase.updateGyroidCurrentVariation(variationMock) }
        }
    }

    @Test
    fun `updateGyroidCurrentVariation should throw Exception when fail to update database`() {
        runBlocking {
            //arrange
            val variationMock = UiVariation(
                gyroidId = 1L,
                imageUrl = "",
                variationId = 11,
                variationName = ""
            )

            coEvery { mockUseCase.updateGyroidCurrentVariation(variationMock) } throws Exception("")

            //act
            viewModel.updateGyroidCurrentVariation(variationMock)

            //assert
            coVerify { mockUseCase.updateGyroidCurrentVariation(variationMock) }
        }
    }

    @Test
    fun `getRandomDialogue should return a random string from usecase`() {
        //arrange
        val expectedString = "mock"
        every { mockUseCase.getRandomDialogue() } returns expectedString

        //act
        val actualString = viewModel.getRandomDialogue()

        //assert
        Assert.assertEquals(expectedString, actualString)
        verify { mockUseCase.getRandomDialogue() }
    }
}