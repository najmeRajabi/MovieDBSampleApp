package com.example.moviedbsampleapp.domain

import android.app.Application
import com.example.moviedbsampleapp.data.MovieLocalDataSource
import com.example.moviedbsampleapp.data.MovieRemoteDataSource
import com.example.moviedbsampleapp.data.MovieRepository
import com.example.moviedbsampleapp.data.database.AppDataBase
import com.example.moviedbsampleapp.data.database.MovieDao
import com.example.moviedbsampleapp.data.network.ApiService
import com.example.moviedbsampleapp.data.network.client
import com.example.moviedbsampleapp.ui.upComing.ComingSoonViewModel
import com.example.moviedbsampleapp.ui.video.MovieViewModel
import com.example.moviedbsampleapp.ui.videoList.MovieListViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://api.themoviedb.org/3/"

val appModule = module {
    single {
        MovieRepository(get(),get())
    }
    single {
        MovieLocalDataSource(get())
    }
    single {
        MovieRemoteDataSource(get())
    }
    single {
        AppDataBase
    }
    single {
        val movieDao = AppDataBase.getAppDataBase(androidContext()).movieDao()
        movieDao
    }
    single {
        val retrofit = get() as Retrofit
        val loginApiService = retrofit.create(ApiService::class.java)
        loginApiService
    }

    single {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .client(client)
            .build()
        retrofit
    }
    viewModel{ ComingSoonViewModel(get()) }
    viewModel{ MovieViewModel(get()) }
    viewModel{ MovieListViewModel(get()) }
}