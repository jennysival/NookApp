package com.jennysival.nookapp.data.local.gyroids

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update

@Dao
interface GyroidDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGyroid(gyroid: DbGyroid): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertVariation(variation: DbVariation)

    @Transaction
    @Query("SELECT * FROM DbGyroid")
    suspend fun getGyroidsWithVariations(): List<GyroidWithVariations>

    @Query("SELECT * FROM DbVariation WHERE gyroidId = :gyroidId")
    suspend fun getVariationsForGyroid(gyroidId: Long): List<DbVariation>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateVariation(variation: DbVariation)

}