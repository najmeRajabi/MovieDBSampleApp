package com.example.moviedbsampleapp.data

import com.example.moviedbsampleapp.data.network.MoviesApi
import com.example.moviedbsampleapp.model.Movie
import com.example.moviedbsampleapp.model.MovieListApiResult
import com.example.moviedbsampleapp.model.VideoApiResult
import java.lang.Exception

class MovieRepository(
    val movieRemoteDataSource : MovieRemoteDataSource ,
    val movieLocalDataSource: MovieLocalDataSource) {

    suspend fun getMovies() : List<Movie>{
        try {
            return movieRemoteDataSource.getMovies()
        }catch (e: Exception){
            if (movieLocalDataSource.getAllMovies().value != null){
                return movieLocalDataSource.getAllMovies().value!!
            }else
                return getSampleMovies()
        }

    }

    fun getSampleMovies() : List<Movie>{
        return listOf(
            Movie( 111,"" , "","supranosfff" , false),
        )
    }

    suspend fun searchMovies(searchKey: String): List<Movie> {
        return movieRemoteDataSource.searchMovie(searchKey)
    }

    suspend fun getUpComingMovies() : List<Movie>{
        try {
            return movieRemoteDataSource.getUpComingMovies()
        }catch (e: Exception){
            // todo return from db if not null
            return getSampleMovies()
        }

    }

    suspend fun getMovie(id: Long): Movie {
        return movieRemoteDataSource.getMovie(id)
    }
    suspend fun getVideo(id: Long): VideoApiResult {
        return movieRemoteDataSource.getVideo(id)
    }


//    suspend fun getYoutubeLink(id : Int) : String {
//        return "youtube /watch v = "+ movieRemoteDataSource.getVideoKey()
//    }

}