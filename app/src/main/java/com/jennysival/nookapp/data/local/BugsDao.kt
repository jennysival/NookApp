package com.jennysival.nookapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.jennysival.nookapp.data.remote.bugs.BugsResponseItem

@Dao
interface BugsDao {

    @Query("SELECT * FROM bugs_table")
    suspend fun getAllBugs(): List<BugsResponseItem>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllBugs(bugsList: List<BugsResponseItem>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateBug(clickedBug: BugsResponseItem)
}