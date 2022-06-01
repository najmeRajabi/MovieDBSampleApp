package com.example.moviedbsampleapp.data

import androidx.lifecycle.LiveData
import com.example.moviedbsampleapp.data.database.MovieDao
import com.example.moviedbsampleapp.model.Movie

class MovieLocalDataSource(
    var movieDao: MovieDao
) {

    fun getAllMovies(): LiveData<List<Movie>> {
        return movieDao.getAllMovies()
    }
}