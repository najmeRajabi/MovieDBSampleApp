package com.example.moviedbsampleapp.model

import com.squareup.moshi.Json

data class Video(
    @Json(name = "name")
    val name: String,

    @Json(name = "key")
    val key: String,

    @Json(name = "id")
    val id: Long,

    @Json(name = "site")
    val site: String

)
