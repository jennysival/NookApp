package com.jennysival.nookapp.ui.gyroids

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jennysival.nookapp.ui.gyroids.model.UiGyroidsModel
import com.jennysival.nookapp.ui.gyroids.model.UiVariation
import com.jennysival.nookapp.usecase.GyroidsUseCase
import com.jennysival.nookapp.utils.ViewState
import kotlinx.coroutines.launch

class GyroidsViewModel(private val useCase: GyroidsUseCase) : ViewModel() {

    private val _gyroidsListState = MutableLiveData<ViewState<List<UiGyroidsModel>>>()
    val gyroidsListState: LiveData<ViewState<List<UiGyroidsModel>>> = _gyroidsListState

    private val _loadState = MutableLiveData<ViewState<Boolean>>()
    val loadState: LiveData<ViewState<Boolean>> = _loadState

    fun getGyroidsFromDatabase() {
        _loadState.value = ViewState.Loading(true)
        viewModelScope.launch {
            try {
                _gyroidsListState.value = useCase.getGyroidsFromDatabase()
            } catch (e: Exception) {
                ViewState.Error(Throwable(e.message))
            } finally {
                _loadState.value = ViewState.Loading(false)
            }
        }
    }

    fun updateGotGyroid(gotGyroid: UiGyroidsModel) {
        viewModelScope.launch {
            try {
                useCase.updateGotGyroid(gotGyroid)
            } catch (e: Exception) {
                ViewState.Error(Throwable(e.message))
            }
        }
    }
}