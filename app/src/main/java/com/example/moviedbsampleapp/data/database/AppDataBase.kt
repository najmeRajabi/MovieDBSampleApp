package com.example.moviedbsampleapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviedbsampleapp.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        @Volatile
        var INSTANCE: AppDataBase? = null

        fun getAppDataBase(context: Context): AppDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "movie_database"
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }

        fun destroyDataBase() {
            INSTANCE = null
        }
    }
}