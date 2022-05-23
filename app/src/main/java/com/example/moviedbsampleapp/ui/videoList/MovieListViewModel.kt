package com.example.moviedbsampleapp.ui.videoList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedbsampleapp.model.Movie
import kotlinx.coroutines.launch

enum class ApiStatus { LOADING, DONE, ERROR }

class MovieListViewModel: ViewModel() {

    val status = MutableLiveData<ApiStatus>()
    val movieList = MutableLiveData<List<Movie>>()

    init {
        getMovies()
    }

    private fun getMovies() {

        status.value = ApiStatus.LOADING
        viewModelScope.launch {

//            val list = Container.movieRepository.getMovies()
//
//            movieList.value = list
//            status.value = ApiStatus.DONE
        }
    }

}