package com.jennysival.nookapp.repository

import com.jennysival.nookapp.data.local.BugsDao
import com.jennysival.nookapp.data.remote.RetrofitService
import com.jennysival.nookapp.data.remote.bugs.BugsResponseItem
import com.jennysival.nookapp.ui.creatures.BugsUiModel

class CreaturesRepository(private val bugsDao: BugsDao) {

    suspend fun getBugsApi(): List<BugsResponseItem> {
        return RetrofitService.apiService.getBugs()
    }

    suspend fun getBugsDatabase(): List<BugsResponseItem> = bugsDao.getAllBugs()

    suspend fun insertBugsDatabase(bugsList: List<BugsResponseItem>) {
        bugsDao.insertAllBugs(bugsList)
    }

    suspend fun updateCatchBugs(catchBug: BugsResponseItem) {
        bugsDao.updateBug(catchBug)
    }

}