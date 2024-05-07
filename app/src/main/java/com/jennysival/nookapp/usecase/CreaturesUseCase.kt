package com.jennysival.nookapp.usecase

import android.database.sqlite.SQLiteConstraintException
import com.jennysival.nookapp.data.local.BugsDao
import com.jennysival.nookapp.data.remote.bugs.BugsResponseItem
import com.jennysival.nookapp.repository.CreaturesRepository
import com.jennysival.nookapp.ui.creatures.BugsUiModel
import com.jennysival.nookapp.utils.ViewState

class CreaturesUseCase(
    private val bugsDao: BugsDao,
    private val creaturesRepository: CreaturesRepository = CreaturesRepository(bugsDao),
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

    private suspend fun insertBugsInDatabase(bugsList: List<BugsResponseItem>) {
        creaturesRepository.insertBugsDatabase(bugsList)
    }

    private suspend fun getBugsFromDatabase(): ViewState<List<BugsUiModel>> {
        return try {
            val bugsList = creaturesRepository.getBugsDatabase()
            ViewState.Success(mapBugsUiModel(bugsList))
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

    private fun mapBugsUiModel(apiBugsList: List<BugsResponseItem>): List<BugsUiModel> {
        return creaturesMapper.getBugsList(apiBugsList).sortedBy {
            it.number.inc()
        }
    }

}