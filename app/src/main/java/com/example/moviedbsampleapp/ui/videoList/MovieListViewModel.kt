package com.example.moviedbsampleapp.ui.videoList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedbsampleapp.data.MovieRepository
import com.example.moviedbsampleapp.model.Movie
import kotlinx.coroutines.launch

enum class ApiStatus { LOADING, DONE, ERROR }

class MovieListViewModel(val movieRepository: MovieRepository): ViewModel() {

    val status = MutableLiveData<ApiStatus>()
    val movieList = MutableLiveData<List<Movie>>()

    init {
        getMovies()
    }

    private fun getMovies() {

        status.value = ApiStatus.LOADING
        viewModelScope.launch {

            val list = getAllMovies()

            movieList.value = list

            status.value = ApiStatus.DONE
        }
    }

    fun searchMovies(searchKey: String)  {
        viewModelScope.launch {
            if (searchKey.isNullOrBlank()) {
                movieList.value= getAllMovies()!!
            } else
                movieList.value= findMovies(searchKey)!!
        }
    }

    suspend fun findMovies(string: String): List<Movie> {
        val result = movieRepository.searchMovies(string)
        return result
    }

    suspend fun getAllMovies(): List<Movie> {
        return movieRepository.getMovies()
    }
}