package com.jennysival.nookapp.repository

import com.jennysival.nookapp.data.local.BugsDao
import com.jennysival.nookapp.data.local.FishesDao
import com.jennysival.nookapp.data.local.SeaDao
import com.jennysival.nookapp.data.remote.RetrofitService
import com.jennysival.nookapp.data.remote.bugs.BugsResponseItem
import com.jennysival.nookapp.data.remote.fishes.FishesResponseItem
import com.jennysival.nookapp.data.remote.sea.SeaResponseItem

class CreaturesRepository(
    private val bugsDao: BugsDao,
    private val fishesDao: FishesDao,
    private val seaDao: SeaDao
) {

    suspend fun getBugsApi(): List<BugsResponseItem> {
        return RetrofitService.apiService.getBugs()
    }

    suspend fun getFishesApi(): List<FishesResponseItem> {
        return RetrofitService.apiService.getFishes()
    }

    suspend fun getSeaApi(): List<SeaResponseItem> {
        return RetrofitService.apiService.getSea()
    }

    suspend fun getBugsDatabase(): List<BugsResponseItem> = bugsDao.getAllBugs()
    suspend fun getFishesDatabase(): List<FishesResponseItem> = fishesDao.getAllFishes()
    suspend fun getSeaDatabase(): List<SeaResponseItem> = seaDao.getAllSea()

    suspend fun insertBugsDatabase(bugsList: List<BugsResponseItem>) {
        bugsDao.insertAllBugs(bugsList)
    }

    suspend fun insertFishesDatabase(fishesList: List<FishesResponseItem>) {
        fishesDao.insertAllFishes(fishesList)
    }

    suspend fun insertSeaDatabase(seaList: List<SeaResponseItem>) {
        seaDao.insertAllSea(seaList)
    }

    suspend fun updateCatchBugs(catchBug: BugsResponseItem) {
        bugsDao.updateBug(catchBug)
    }

    suspend fun updateCatchFish(catchFish: FishesResponseItem) {
        fishesDao.updateFish(catchFish)
    }

    suspend fun updateCatchSea(catchSea: SeaResponseItem) {
        seaDao.updateSea(catchSea)
    }

}