package com.jennysival.nookapp.repository

import com.jennysival.nookapp.data.local.gyroids.GyroidsDao
import com.jennysival.nookapp.data.local.gyroids.GyroidsEntity
import com.jennysival.nookapp.data.remote.RetrofitService
import com.jennysival.nookapp.data.remote.gyroids.ApiGyroidsResponseItem
import com.jennysival.nookapp.ui.gyroids.BrewsterDialogues

class GyroidsRepository(
    private val gyroidsDao: GyroidsDao
) {

    suspend fun getGyroidsFromApi(): List<ApiGyroidsResponseItem> {
        return RetrofitService.apiService.getGyroids()
    }

    suspend fun getGyroidsDatabase(): List<GyroidsEntity> = gyroidsDao.getAllGyroids()

    suspend fun insertBugsDatabase(gyroidsList: List<GyroidsEntity>) {
        gyroidsDao.insertAllGyroids(gyroidsList)
    }

    suspend fun updateGyroid(gotGyroid: GyroidsEntity) {
        gyroidsDao.updateGyroid(gotGyroid)
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