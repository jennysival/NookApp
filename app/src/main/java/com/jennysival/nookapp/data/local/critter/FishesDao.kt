package com.jennysival.nookapp.data.local.critter

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.jennysival.nookapp.data.remote.fishes.FishesResponseItem

@Dao
interface FishesDao {

    @Query("SELECT * FROM fishes_table")
    suspend fun getAllFishes(): List<FishesResponseItem>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllFishes(fishesList: List<FishesResponseItem>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFish(clickedFish: FishesResponseItem)
}