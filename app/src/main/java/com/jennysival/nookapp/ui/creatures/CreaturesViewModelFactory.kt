package com.jennysival.nookapp.ui.creatures

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jennysival.nookapp.data.local.BugsDao
import com.jennysival.nookapp.data.local.BugsDatabase
import com.jennysival.nookapp.usecase.CreaturesUseCase

class CreaturesViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val bugsDao: BugsDao = BugsDatabase.getBugsDatabase(context).bugsDao()

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val useCase = CreaturesUseCase(bugsDao = bugsDao)
        return CreaturesViewModel(useCase) as T
    }

}
