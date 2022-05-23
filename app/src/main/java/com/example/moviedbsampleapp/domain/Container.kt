package com.example.moviedbsampleapp.domain

import com.example.moviedbsampleapp.data.MovieRemoteDataSource
import com.example.moviedbsampleapp.data.MovieRepository

object Container {
    val movieRemoteDataSource = MovieRemoteDataSource()
    val movieRepository = MovieRepository(movieRemoteDataSource)
}