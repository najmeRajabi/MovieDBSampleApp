package com.example.moviedbsampleapp.data

import com.example.moviedbsampleapp.model.Movie

class MovieRepository(val movieRemoteDataSource : MovieRemoteDataSource ,) {

    suspend fun getMovies() : List<Movie>{
        return movieRemoteDataSource.getMovies()

    }

    suspend fun searchMovies(searchKey: String): List<Movie> {
        return movieRemoteDataSource.searchMovie(searchKey)
    }

    suspend fun getYoutubeLink(id : Int) : String {
        return "youtube /watch v = "+ movieRemoteDataSource.getVideoKey()
    }

}