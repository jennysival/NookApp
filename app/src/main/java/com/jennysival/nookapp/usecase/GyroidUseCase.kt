package com.jennysival.nookapp.usecase

import android.database.sqlite.SQLiteConstraintException
import com.jennysival.nookapp.data.local.gyroids.ApiToDbMapper
import com.jennysival.nookapp.data.local.gyroids.DbVariation
import com.jennysival.nookapp.data.local.gyroids.GyroidDao
import com.jennysival.nookapp.data.local.gyroids.GyroidWithVariations
import com.jennysival.nookapp.data.remote.gyroids.ApiGyroidsResponseItem
import com.jennysival.nookapp.repository.GyroidRepository
import com.jennysival.nookapp.ui.gyroids.model.UiGyroidsModel
import com.jennysival.nookapp.ui.gyroids.model.UiVariation
import com.jennysival.nookapp.utils.ViewState

class GyroidUseCase(
    private val gyroidDao: GyroidDao,
    private val gyroidRepository: GyroidRepository = GyroidRepository(gyroidDao),
    private val gyroidUiMapper: UiMapper = UiMapper(),
    private val gyroidApiMapper: ApiToDbMapper = ApiToDbMapper()
) {

    private suspend fun getGyroidsFromApi(): ViewState<List<UiGyroidsModel>> {
        return try {
            insertGyroidsInDatabase(gyroidRepository.getGyroidsFromApi())
            getGyroidListFromDatabase()
        } catch (e: Exception) {
            ViewState.Error(Exception(e.message))
        }
    }

    private suspend fun insertGyroidsInDatabase(apiList: List<ApiGyroidsResponseItem>) {
        apiList.forEach { gyroid ->
            val gyroidId =
                gyroidRepository.insertGyroidInDatabase(gyroidApiMapper.mapApiToDbGyroid(gyroid))
            gyroid.variations.forEach { apiVariation ->
                val variation = gyroidApiMapper.mapApiToDbVariation(
                    gyroidId = gyroidId,
                    apiVariation = apiVariation
                )
                gyroidRepository.insertVariationInDatabase(variation)
            }
        }
    }

    suspend fun getGyroidListFromDatabase(): ViewState<List<UiGyroidsModel>> {
        return try {
            val dbGyroidsList: List<GyroidWithVariations> =
                gyroidRepository.getGyroidListFromDatabase()

            if (dbGyroidsList.isEmpty()) {
                getGyroidsFromApi()
            } else {
                ViewState.Success(gyroidUiMapper.mapDbToUi(dbGyroidsList))
            }
        } catch (e: SQLiteConstraintException) {
            ViewState.Error(Exception(e.message))
        }
    }

    suspend fun getVariationsFromDatabase(gyroidId: Long): ViewState<List<UiVariation>> {
        return try {
            val dbVariationsList: List<DbVariation> = gyroidRepository.getVariations(gyroidId)
            ViewState.Success(gyroidUiMapper.mapVariationDbToUi(dbVariationsList))
        } catch (e: SQLiteConstraintException) {
            ViewState.Error(Exception(e.message))
        }
    }

    suspend fun updateGyroidCurrentVariation(variation: UiVariation) {
        try {
            gyroidRepository.updateVariation(gyroidUiMapper.mapUiToDbVariation(variation))
        } catch (e: SQLiteConstraintException) {
            ViewState.Error(Exception(e.message))
        }
    }

    fun getRandomDialogue(): String = gyroidRepository.getRandomDialogue()

}