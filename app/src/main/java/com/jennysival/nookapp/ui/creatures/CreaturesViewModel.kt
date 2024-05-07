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

    fun getBugs() {
        viewModelScope.launch {
            try {
                _bugsListState.value = useCase.getBugs()
            } catch (e: Exception) {
                _bugsListState.value = ViewState.Error(Throwable(e.message))
            }
        }
    }
}