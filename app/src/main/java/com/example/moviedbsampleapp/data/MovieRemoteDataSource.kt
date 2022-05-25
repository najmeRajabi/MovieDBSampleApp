package com.example.moviedbsampleapp.data

import com.example.moviedbsampleapp.model.Movie
import com.example.moviedbsampleapp.data.network.MoviesApi


class MovieRemoteDataSource {

    suspend fun getMovies() : List<Movie>{
        try {
            return MoviesApi.retrofitService.getMovies().movieList

            }catch (e : Exception){
            return getSampleMovies(e.toString())
        }

    }
    fun getSampleMovies(e: String) : List<Movie>{
        return listOf(
            Movie(listOf(), 111,"$e " , "","supranosfff" , false),
        )
    }

    suspend fun getVideoKey() : String
    {
        //TODO : return video key
        return ""
    }

    suspend fun searchMovie(searchKey:String) : List<Movie>{
        return MoviesApi.retrofitService.searchMovie(searchKey,).movieList
    }
}