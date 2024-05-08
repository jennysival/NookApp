package com.jennysival.nookapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.jennysival.nookapp.data.remote.sea.SeaResponseItem

@Dao
interface SeaDao {

    @Query("SELECT * FROM sea_table")
    suspend fun getAllSea(): List<SeaResponseItem>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllSea(seaList: List<SeaResponseItem>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateSea(clickedSea: SeaResponseItem)
}