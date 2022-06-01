package com.example.moviedbsampleapp.ui.video

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedbsampleapp.data.MovieRepository
import com.example.moviedbsampleapp.model.Movie
import com.example.moviedbsampleapp.model.Video
import kotlinx.coroutines.launch

class MovieViewModel(val movieRepository: MovieRepository):ViewModel() {

    val movie = MutableLiveData<Movie>()
    val video = MutableLiveData<Video>()



    fun getMovie(id: Long , context: Context){
        viewModelScope.launch {
            try {
                movie.value = movieRepository.getMovie(id)
                getVideo(id)
            }catch (e: Exception){
                Log.d("-----TAG", "getMovie exception: $e")
                Toast.makeText(context, "something is wrong: $e",Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun playVideo(): String {
        movie.value?.id?.let { getVideo(it) }
        return "https://www.youtube.com/watch?v="+video.value?.key
    }


    fun getVideo(id: Long){
        viewModelScope.launch {
            try {
                video.value = movieRepository.getVideo(id).videoList[0]
            }catch (e: Exception){
                Log.d("videoVM-----TAG", "getVideo: $e")
            }
        }
    }
}