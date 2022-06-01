package com.example.moviedbsampleapp.model

import com.squareup.moshi.Json

data class VideoApiResult(
    @Json(name = "id")
    val id: Long,

    @Json(name = "results")
    val videoList: List<Video>
)
