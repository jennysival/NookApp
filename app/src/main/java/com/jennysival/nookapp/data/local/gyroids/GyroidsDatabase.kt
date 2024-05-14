package com.jennysival.nookapp.data.local.gyroids

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GyroidsEntity::class], version = 5)
abstract class GyroidsDatabase : RoomDatabase() {

    abstract fun gyroidsDao(): GyroidsDao

    companion object {
        @Volatile
        private var INSTANCE: GyroidsDatabase? = null

        fun getGyroidsDatabase(context: Context): GyroidsDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GyroidsDatabase::class.java,
                    "gyroids_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}