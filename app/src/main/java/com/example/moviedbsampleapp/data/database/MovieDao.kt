package com.example.moviedbsampleapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moviedbsampleapp.model.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM Movie")
    fun getAllMovies(): LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll (vararg movie: Movie)

    @Update
    suspend fun updateWord (movie: Movie)

    @Query("SELECT * FROM movie WHERE title LIKE '%' || :str || '%' ")
    fun findMovie(str:String): LiveData<List<Movie>>
}