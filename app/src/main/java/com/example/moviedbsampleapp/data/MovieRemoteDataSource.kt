package com.example.moviedbsampleapp.data

import com.example.moviedbsampleapp.data.network.ApiService
import com.example.moviedbsampleapp.model.Movie
import com.example.moviedbsampleapp.data.network.MoviesApi
import com.example.moviedbsampleapp.model.MovieListApiResult
import com.example.moviedbsampleapp.model.VideoApiResult


class MovieRemoteDataSource (var apiService: ApiService){

    suspend fun getMovies() : List<Movie>{
        return apiService.getMovies().movieList
    }



    suspend fun searchMovie(searchKey:String) : List<Movie>{
        return apiService.searchMovie(searchKey,).movieList
    }

    suspend fun getUpComingMovies(): List<Movie> {
            return apiService.getUpComingMovies().movieList
    }

    suspend fun getMovie(id: Long): Movie {
        return apiService.getMovie(id)
    }

    suspend fun getVideo(id: Long): VideoApiResult {
        return apiService.getVideo(id)
    }
}