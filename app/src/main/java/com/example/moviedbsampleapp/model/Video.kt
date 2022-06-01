package com.example.moviedbsampleapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class Video(
    @Json(name = "name")
    val name: String,

    @Json(name = "key")
    val key: String,

    @Json(name = "id")
    @PrimaryKey val id: Long,

    @Json(name = "site")
    val site: String

)
