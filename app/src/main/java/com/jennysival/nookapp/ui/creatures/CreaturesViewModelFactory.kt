package com.jennysival.nookapp.ui.creatures

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jennysival.nookapp.usecase.CreaturesUseCase

class CreaturesViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val usecase = CreaturesUseCase()
        return CreaturesViewModel(usecase) as T
    }
}