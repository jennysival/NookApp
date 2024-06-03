package com.jennysival.nookapp.repository

import com.jennysival.nookapp.data.local.gyroids.DbGyroid
import com.jennysival.nookapp.data.local.gyroids.DbVariation
import com.jennysival.nookapp.data.local.gyroids.GyroidDao
import com.jennysival.nookapp.data.local.gyroids.GyroidWithVariations
import com.jennysival.nookapp.data.remote.RetrofitService
import com.jennysival.nookapp.data.remote.gyroids.ApiGyroidsResponseItem
import com.jennysival.nookapp.ui.gyroids.BrewsterDialogues

class GyroidRepository(
    private val gyroidDao: GyroidDao
) {

    suspend fun getGyroidsFromApi(): List<ApiGyroidsResponseItem> {
        return RetrofitService.apiService.getGyroids()
    }

    suspend fun getGyroidListFromDatabase(): List<GyroidWithVariations> =
        gyroidDao.getGyroidsWithVariations()

    suspend fun getVariations(gyroidId: Long): List<DbVariation> =
        gyroidDao.getVariationsForGyroid(gyroidId)


    suspend fun insertGyroidInDatabase(gyroid: DbGyroid): Long = gyroidDao.insertGyroid(gyroid)

    suspend fun insertVariationInDatabase(variation: DbVariation) {
        gyroidDao.insertVariation(variation)
    }

    suspend fun updateVariation(variation: DbVariation) {
        gyroidDao.updateVariation(variation)
    }


    fun getRandomDialogue(): String {
        return listOf(
            BrewsterDialogues.RANDOM_DIALOGUE_ONE,
            BrewsterDialogues.RANDOM_DIALOGUE_TWO,
            BrewsterDialogues.RANDOM_DIALOGUE_THREE,
            BrewsterDialogues.RANDOM_DIALOGUE_FOUR,
            BrewsterDialogues.RANDOM_DIALOGUE_FIVE
        ).random()
    }
}