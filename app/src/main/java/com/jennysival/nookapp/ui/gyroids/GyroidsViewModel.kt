package com.jennysival.nookapp.ui.gyroids

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jennysival.nookapp.ui.gyroids.model.UiGyroidsModel
import com.jennysival.nookapp.ui.gyroids.model.UiVariation
import com.jennysival.nookapp.usecase.GyroidUseCase
import com.jennysival.nookapp.utils.ViewState
import kotlinx.coroutines.launch

class GyroidsViewModel(private val useCase: GyroidUseCase) : ViewModel() {

    private val _gyroidsListState = MutableLiveData<ViewState<List<UiGyroidsModel>>>()
    val gyroidsListState: LiveData<ViewState<List<UiGyroidsModel>>> = _gyroidsListState

    private val _variationsListState = MutableLiveData<ViewState<List<UiVariation>>>()
    val variationsListState: LiveData<ViewState<List<UiVariation>>> = _variationsListState

    private val _loadState = MutableLiveData<ViewState<Boolean>>()
    val loadState: LiveData<ViewState<Boolean>> = _loadState

    private val _nameState = MutableLiveData<ViewState<String>>()
    val nameState: LiveData<ViewState<String>> = _nameState

    fun getGyroidsFromDatabase() {
        _loadState.value = ViewState.Loading(true)
        viewModelScope.launch {
            try {
                _gyroidsListState.value = useCase.getGyroidListFromDatabase()
            } catch (e: Exception) {
                ViewState.Error(Throwable(e.message))
            } finally {
                _loadState.value = ViewState.Loading(false)
            }
        }
    }

    fun getVariations(gyroidId: Long) {
        _loadState.value = ViewState.Loading(true)
        viewModelScope.launch {
            try {
                _variationsListState.value = useCase.getVariationsFromDatabase(gyroidId)
            } catch (e: Exception) {
                ViewState.Error(Throwable(e.message))
            } finally {
                _loadState.value = ViewState.Loading(false)
            }
        }
    }

    fun updateGyroidCurrentVariation(variation: UiVariation) {
        viewModelScope.launch {
            try {
                useCase.updateGyroidCurrentVariation(variation)
            } catch (e: Exception) {
                ViewState.Error(Throwable(e.message))
            }
        }
    }

    fun getRandomDialogue(): String = useCase.getRandomDialogue()
}