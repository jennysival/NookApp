package com.jennysival.nookapp.usecase

import android.database.sqlite.SQLiteConstraintException
import com.jennysival.nookapp.data.local.BugsDao
import com.jennysival.nookapp.data.local.FishesDao
import com.jennysival.nookapp.data.local.SeaDao
import com.jennysival.nookapp.data.remote.bugs.BugsResponseItem
import com.jennysival.nookapp.data.remote.fishes.FishesResponseItem
import com.jennysival.nookapp.data.remote.sea.SeaResponseItem
import com.jennysival.nookapp.repository.CreaturesRepository
import com.jennysival.nookapp.ui.creatures.bugs.BugsUiModel
import com.jennysival.nookapp.ui.creatures.fishes.FishesUiModel
import com.jennysival.nookapp.ui.creatures.sea.SeaUiModel
import com.jennysival.nookapp.utils.ViewState

class CreaturesUseCase(
    private val bugsDao: BugsDao,
    private val fishesDao: FishesDao,
    private val seaDao: SeaDao,
    private val creaturesRepository: CreaturesRepository = CreaturesRepository(bugsDao, fishesDao, seaDao),
    private val creaturesMapper: CreaturesMapper = CreaturesMapper()
    ) {

    suspend fun getBugsApi() : ViewState<List<BugsUiModel>> {
        return try {
            val apiBugsList = creaturesRepository.getBugsApi()
            insertBugsInDatabase(apiBugsList)
            getBugsFromDatabase()
        } catch (e: Exception) {
            ViewState.Error(Exception(e.message))
        }
    }

    suspend fun getFishesFromApi() : ViewState<List<FishesUiModel>> {
        return try {
            val apiFishesList = creaturesRepository.getFishesApi()
            insertFishesInDatabase(apiFishesList)
            getFishesFromDatabase()
        } catch (e: Exception) {
            ViewState.Error(Exception(e.message))
        }
    }
    suspend fun getSeaFromApi() : ViewState<List<SeaUiModel>> {
        return try {
            val apiSeaList = creaturesRepository.getSeaApi()
            insertSeaInDatabase(apiSeaList)
            getSeaFromDatabase()
        } catch (e: Exception) {
            ViewState.Error(Exception(e.message))
        }
    }

    private suspend fun insertBugsInDatabase(bugsList: List<BugsResponseItem>) {
        creaturesRepository.insertBugsDatabase(bugsList)
    }
    private suspend fun insertFishesInDatabase(fishesList: List<FishesResponseItem>) {
        creaturesRepository.insertFishesDatabase(fishesList)
    }
    private suspend fun insertSeaInDatabase(seaList: List<SeaResponseItem>) {
        creaturesRepository.insertSeaDatabase(seaList)
    }

    private suspend fun getBugsFromDatabase(): ViewState<List<BugsUiModel>> {
        return try {
            val bugsList = creaturesRepository.getBugsDatabase()
            ViewState.Success(mapBugsUiModel(bugsList))
        } catch (e: SQLiteConstraintException) {
            ViewState.Error(Exception(e.message))
        }
    }
    private suspend fun getFishesFromDatabase(): ViewState<List<FishesUiModel>> {
        return try {
            val fishesList = creaturesRepository.getFishesDatabase()
            ViewState.Success(mapFishesUiModel(fishesList))
        } catch (e: SQLiteConstraintException) {
            ViewState.Error(Exception(e.message))
        }
    }
    private suspend fun getSeaFromDatabase(): ViewState<List<SeaUiModel>> {
        return try {
            val seaList = creaturesRepository.getSeaDatabase()
            ViewState.Success(mapSeaUiModel(seaList))
        } catch (e: SQLiteConstraintException) {
            ViewState.Error(Exception(e.message))
        }
    }

    suspend fun updateCatchBugs(catchBug: BugsUiModel): ViewState<BugsUiModel> {
        return try {
            val mapBugs = creaturesMapper.getCatchBug(catchBug)
            creaturesRepository.updateCatchBugs(mapBugs)
            ViewState.Success(catchBug)
        } catch (e: SQLiteConstraintException) {
            ViewState.Error(Exception(e.message))
        }
    }
    suspend fun updateCatchFish(catchFish: FishesUiModel): ViewState<FishesUiModel> {
        return try {
            val mapFish = creaturesMapper.getCatchFish(catchFish)
            creaturesRepository.updateCatchFish(mapFish)
            ViewState.Success(catchFish)
        } catch (e: SQLiteConstraintException) {
            ViewState.Error(Exception(e.message))
        }
    }
    suspend fun updateCatchSea(catchSea: SeaUiModel): ViewState<SeaUiModel> {
        return try {
            val mapSea = creaturesMapper.getCatchSea(catchSea)
            creaturesRepository.updateCatchSea(mapSea)
            ViewState.Success(catchSea)
        } catch (e: SQLiteConstraintException) {
            ViewState.Error(Exception(e.message))
        }
    }

    private fun mapBugsUiModel(apiBugsList: List<BugsResponseItem>): List<BugsUiModel> {
        return creaturesMapper.getBugsList(apiBugsList).sortedBy {
            it.number.inc()
        }
    }
    private fun mapFishesUiModel(apiFishesList: List<FishesResponseItem>): List<FishesUiModel> {
        return creaturesMapper.getFishesList(apiFishesList).sortedBy {
            it.number.inc()
        }
    }

    private fun mapSeaUiModel(apiSeaList: List<SeaResponseItem>): List<SeaUiModel> {
        return creaturesMapper.getSeaList(apiSeaList).sortedBy {
            it.number.inc()
        }
    }

}