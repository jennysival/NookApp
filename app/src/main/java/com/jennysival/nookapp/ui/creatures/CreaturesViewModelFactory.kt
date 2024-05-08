package com.jennysival.nookapp.ui.creatures

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jennysival.nookapp.data.local.BugsDao
import com.jennysival.nookapp.data.local.CritterDatabase
import com.jennysival.nookapp.data.local.FishesDao
import com.jennysival.nookapp.data.local.SeaDao
import com.jennysival.nookapp.usecase.CreaturesUseCase

class CreaturesViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val bugsDao: BugsDao = CritterDatabase.getBugsDatabase(context).bugsDao()
    private val fishesDao: FishesDao = CritterDatabase.getFishesDatabase(context).fishesDao()
    private val seaDao: SeaDao = CritterDatabase.getSeaDatabase(context).seaDao()

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val useCase = CreaturesUseCase(bugsDao = bugsDao, fishesDao = fishesDao, seaDao = seaDao)
        return CreaturesViewModel(useCase) as T
    }

}
