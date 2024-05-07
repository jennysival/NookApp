package com.jennysival.nookapp.ui.creatures

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jennysival.nookapp.usecase.CreaturesUseCase
import com.jennysival.nookapp.utils.ViewState
import kotlinx.coroutines.launch

class CreaturesViewModel(private val useCase: CreaturesUseCase) : ViewModel() {
    private val _bugsListState = MutableLiveData<ViewState<List<BugsUiModel>>>()
    val bugsListState: LiveData<ViewState<List<BugsUiModel>>> = _bugsListState

    private val _catchBugState = MutableLiveData<ViewState<BugsUiModel>>()
    val catchBugState: LiveData<ViewState<BugsUiModel>> = _catchBugState

    fun getBugs() {
        viewModelScope.launch {
            try {
                _bugsListState.value = useCase.getBugsApi()
            } catch (e: Exception) {
                _bugsListState.value = ViewState.Error(Throwable(e.message))
            }
        }
    }

    fun updateCatchBug(catchBug: BugsUiModel) {
        viewModelScope.launch {
            try {
                _catchBugState.value = useCase.updateCatchBugs(catchBug)
            } catch (e: Exception) {
                _catchBugState.value = ViewState.Error(Throwable(e.message))
            }
        }
    }
}