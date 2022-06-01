package com.example.moviedbsampleapp.ui.video

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedbsampleapp.domain.Container
import com.example.moviedbsampleapp.model.Movie
import kotlinx.coroutines.launch

class MovieViewModel:ViewModel() {

    val movie = MutableLiveData<Movie>()

    fun getMovie(id: Long , context: Context){
        viewModelScope.launch {
            try {
                movie.value = Container.movieRepository.getMovie(id)
            }catch (e: Exception){
                Log.d("-----TAG", "getMovie exception: $e")
                Toast.makeText(context, "something is wrong: $e",Toast.LENGTH_SHORT).show()
            }
        }
    }
}