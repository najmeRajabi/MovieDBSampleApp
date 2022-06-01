package com.example.moviedbsampleapp.data.database

import androidx.room.*
import com.example.moviedbsampleapp.model.Video

@Dao
interface VideoDao {

    @Query("SELECT * FROM Video WHERE id = :id")
    suspend fun getVideo(id : Long): Video

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll (vararg video: Video)

    @Update
    suspend fun updateVideo (video: Video)
}