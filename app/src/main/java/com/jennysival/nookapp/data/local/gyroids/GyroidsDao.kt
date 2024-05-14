package com.jennysival.nookapp.data.local.gyroids

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface GyroidsDao {

    @Query("SELECT * FROM gyroids_table")
    suspend fun getAllGyroids(): List<GyroidsEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllGyroids(gyroidsList: List<GyroidsEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateGyroid(clickedGyroid: GyroidsEntity)
}