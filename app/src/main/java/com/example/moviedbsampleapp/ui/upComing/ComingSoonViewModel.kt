package com.example.moviedbsampleapp.ui.upComing

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedbsampleapp.data.MovieRepository
import com.example.moviedbsampleapp.model.Movie
import com.example.moviedbsampleapp.ui.videoList.ApiStatus
import kotlinx.coroutines.launch

class ComingSoonViewModel(val movieRepository: MovieRepository):ViewModel() {

    val upComingVideos = MutableLiveData<List<Movie>>()
    val status = MutableLiveData<ApiStatus>()

    init {
        getUpComingMovies()
    }

    private fun getUpComingMovies() {

        status.value = ApiStatus.LOADING
        viewModelScope.launch {

            val list = movieRepository.getUpComingMovies()
            upComingVideos.value = list
            status.value = ApiStatus.DONE
        }
    }
}