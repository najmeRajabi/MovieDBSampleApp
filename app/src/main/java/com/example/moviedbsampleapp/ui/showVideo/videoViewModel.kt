package com.example.moviedbsampleapp.ui.showVideo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedbsampleapp.domain.Container
import com.example.moviedbsampleapp.model.Video
import kotlinx.coroutines.launch

class videoViewModel: ViewModel() {

    val video = MutableLiveData<Video>()

    fun getVideo(id: Long){
        viewModelScope.launch {
            try {
                video.value = Container.movieRepository.getVideo(id).videoList[0]
            }catch (e: Exception){
                Log.d("videoVM-----TAG", "getVideo: $e")
            }
        }
    }
}