package com.example.moviedbsampleapp.ui.video

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviedbsampleapp.model.Movie

class MovieViewModel:ViewModel() {

    val movie = MutableLiveData<Movie>()
}