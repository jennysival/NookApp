package com.jennysival.nookapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jennysival.nookapp.data.remote.bugs.BugsResponseItem
import com.jennysival.nookapp.data.remote.fishes.FishesResponseItem
import com.jennysival.nookapp.data.remote.sea.SeaResponseItem

@Database(entities = [
    BugsResponseItem::class,
    FishesResponseItem::class,
    SeaResponseItem::class
                     ], version = 2)
abstract class CritterDatabase : RoomDatabase() {

    abstract fun bugsDao(): BugsDao
    abstract fun fishesDao(): FishesDao
    abstract fun seaDao(): SeaDao

    companion object {
        @Volatile
        private var INSTANCE: CritterDatabase? = null

        fun getBugsDatabase(context: Context): CritterDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CritterDatabase::class.java,
                    "bugs_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }

        fun getFishesDatabase(context: Context): CritterDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CritterDatabase::class.java,
                    "fishes_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }

        fun getSeaDatabase(context: Context): CritterDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CritterDatabase::class.java,
                    "sea_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}