package com.jennysival.nookapp.ui.creatures

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jennysival.nookapp.ui.creatures.bugs.BugsUiModel
import com.jennysival.nookapp.ui.creatures.fishes.FishesUiModel
import com.jennysival.nookapp.ui.creatures.sea.SeaUiModel
import com.jennysival.nookapp.usecase.CreaturesUseCase
import com.jennysival.nookapp.utils.ViewState
import kotlinx.coroutines.launch

class CreaturesViewModel(private val useCase: CreaturesUseCase) : ViewModel() {
    private val _bugsListState = MutableLiveData<ViewState<List<BugsUiModel>>>()
    val bugsListState: LiveData<ViewState<List<BugsUiModel>>> = _bugsListState

    private val _fishesListState = MutableLiveData<ViewState<List<FishesUiModel>>>()
    val fishesListState: LiveData<ViewState<List<FishesUiModel>>> = _fishesListState

    private val _seaListState = MutableLiveData<ViewState<List<SeaUiModel>>>()
    val seaListState: LiveData<ViewState<List<SeaUiModel>>> = _seaListState

    private val _loadState = MutableLiveData<ViewState<Boolean>>()
    val loadState: LiveData<ViewState<Boolean>> = _loadState

    fun getBugsFromDatabase() {
        _loadState.value = ViewState.Loading(true)
        viewModelScope.launch {
            try {
                _bugsListState.value = useCase.getBugsFromDatabase()
            } catch (e: Exception) {
                ViewState.Error(Throwable(e.message))
            } finally {
                _loadState.value = ViewState.Loading(false)
            }
        }
    }

    fun updateCatchBug(catchBug: BugsUiModel) {
        viewModelScope.launch {
            try {
                useCase.updateCatchBugs(catchBug)
            } catch (e: Exception) {
                ViewState.Error(Throwable(e.message))
            }
        }
    }

    fun getFishesFromDatabase() {
        _loadState.value = ViewState.Loading(true)
        viewModelScope.launch {
            try {
                _fishesListState.value = useCase.getFishesFromDatabase()
            } catch (e: Exception) {
                ViewState.Error(Throwable(e.message))
            } finally {
                _loadState.value = ViewState.Loading(false)
            }
        }
    }

    fun updateCatchFish(catchFish: FishesUiModel) {
        viewModelScope.launch {
            try {
                useCase.updateCatchFish(catchFish)
            } catch (e: Exception) {
                ViewState.Error(Throwable(e.message))
            }
        }
    }

    fun getSeaFromDatabase() {
        _loadState.value = ViewState.Loading(true)
        viewModelScope.launch {
            try {
                _seaListState.value = useCase.getSeaFromDatabase()
            } catch (e: Exception) {
                ViewState.Error(Throwable(e.message))
            } finally {
                _loadState.value = ViewState.Loading(false)
            }
        }
    }

    fun updateCatchSea(catchSea: SeaUiModel) {
        viewModelScope.launch {
            try {
                useCase.updateCatchSea(catchSea)
            } catch (e: Exception) {
                ViewState.Error(Throwable(e.message))
            }
        }
    }
}