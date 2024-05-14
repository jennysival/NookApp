package com.jennysival.nookapp.usecase

import android.database.sqlite.SQLiteConstraintException
import com.jennysival.nookapp.data.local.gyroids.GyroidApiDbMapper
import com.jennysival.nookapp.data.local.gyroids.GyroidsDao
import com.jennysival.nookapp.data.local.gyroids.GyroidsEntity
import com.jennysival.nookapp.repository.GyroidsRepository
import com.jennysival.nookapp.ui.gyroids.model.UiGyroidsModel
import com.jennysival.nookapp.utils.ViewState

class GyroidsUseCase(
    private val gyroidsDao: GyroidsDao,
    private val gyroidsRepository: GyroidsRepository = GyroidsRepository(gyroidsDao),
    private val gyroidsUiMapper: GyroidsMapper = GyroidsMapper(),
    private val gyroidsApiMapper: GyroidApiDbMapper = GyroidApiDbMapper()
) {

    private suspend fun getGyroidsFromApi(): ViewState<List<UiGyroidsModel>> {
        return try {
            val apiGyroidsList = gyroidsRepository.getGyroidsFromApi()
            insertGyroidsInDatabase(gyroidsApiMapper.mapApiToDb(apiGyroidsList))
            getGyroidsFromDatabase()
        } catch (e: Exception) {
            ViewState.Error(Exception(e.message))
        }
    }

    private suspend fun insertGyroidsInDatabase(gyroidsList: List<GyroidsEntity>) {
        gyroidsRepository.insertBugsDatabase(gyroidsList)
    }

    suspend fun getGyroidsFromDatabase(): ViewState<List<UiGyroidsModel>> {
        return try {
            val gyroidsList = gyroidsRepository.getGyroidsDatabase()
            if (gyroidsList.isEmpty()) {
                getGyroidsFromApi()
            } else {
                ViewState.Success(gyroidsUiMapper.mapDbToUi(gyroidsList))
            }
        } catch (e: SQLiteConstraintException) {
            ViewState.Error(Exception(e.message))
        }
    }

    suspend fun updateGotGyroid(gotGyroid: UiGyroidsModel): ViewState<UiGyroidsModel> {
        return try {
            val mapGyroid = gyroidsUiMapper.mapSingleUiToDb(gotGyroid)
            gyroidsRepository.updateGyroid(mapGyroid)
            ViewState.Success(gotGyroid)
        } catch (e: SQLiteConstraintException) {
            ViewState.Error(Exception(e.message))
        }
    }

    fun getRandomDialogue(): String = gyroidsRepository.getRandomDialogue()

}