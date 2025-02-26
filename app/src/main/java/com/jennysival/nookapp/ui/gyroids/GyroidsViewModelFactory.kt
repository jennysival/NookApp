package com.jennysival.nookapp.ui.gyroids

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jennysival.nookapp.data.local.gyroids.GyroidDao
import com.jennysival.nookapp.data.local.gyroids.GyroidDatabase
import com.jennysival.nookapp.usecase.GyroidUseCase

class GyroidsViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val gyroidDao: GyroidDao = GyroidDatabase.getGyroidDatabase(context).gyroidDao()

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val useCase = GyroidUseCase(gyroidDao)
        return GyroidsViewModel(useCase) as T
    }

}
