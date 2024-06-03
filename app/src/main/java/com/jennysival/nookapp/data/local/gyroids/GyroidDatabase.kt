package com.jennysival.nookapp.data.local.gyroids

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DbGyroid::class, DbVariation::class], version = 1)
abstract class GyroidDatabase : RoomDatabase() {

    abstract fun gyroidDao(): GyroidDao

    companion object {
        @Volatile
        private var INSTANCE: GyroidDatabase? = null

        fun getGyroidDatabase(context: Context): GyroidDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GyroidDatabase::class.java,
                    "gyroids_db"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}