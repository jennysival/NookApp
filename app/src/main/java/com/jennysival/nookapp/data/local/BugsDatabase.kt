package com.jennysival.nookapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jennysival.nookapp.data.remote.bugs.BugsResponseItem

@Database(entities = [BugsResponseItem::class], version = 1)
abstract class BugsDatabase : RoomDatabase() {

    abstract fun bugsDao(): BugsDao

    companion object {
        @Volatile
        private var INSTANCE: BugsDatabase? = null

        fun getBugsDatabase(context: Context): BugsDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BugsDatabase::class.java,
                    "bugs_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}