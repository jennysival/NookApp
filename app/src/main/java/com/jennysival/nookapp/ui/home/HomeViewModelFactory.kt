package com.jennysival.nookapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jennysival.nookapp.repository.FeaturesRepository

class HomeViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repository = FeaturesRepository()
        return HomeViewModel(repository) as T
    }
}