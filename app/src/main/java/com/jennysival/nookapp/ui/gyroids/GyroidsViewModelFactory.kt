package com.jennysival.nookapp.ui.gyroids

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jennysival.nookapp.data.local.gyroids.GyroidsDao
import com.jennysival.nookapp.data.local.gyroids.GyroidsDatabase
import com.jennysival.nookapp.usecase.GyroidsUseCase

class GyroidsViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val gyroidsDao: GyroidsDao = GyroidsDatabase.getGyroidsDatabase(context).gyroidsDao()

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val useCase = GyroidsUseCase(gyroidsDao)
        return GyroidsViewModel(useCase) as T
    }

}
