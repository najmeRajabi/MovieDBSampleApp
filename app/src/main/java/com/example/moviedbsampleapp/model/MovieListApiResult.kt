package com.example.moviedbsampleapp.model

import com.squareup.moshi.Json

data class MovieListApiResult (
    @Json(name = "page")
    val page: Int,

    @Json(name = "results")
    val movieList: List<Movie>
)

/*

sample code :

{
   "name":"zeinab",
   [
      {
         "city":"Tehran",
         "address":"azadi str"
      },
      {
         "city":"yazd",
         "address":"azadi str"
      }
   ]
}

data class User(
    val name : String,
    val locationInformation : List<LocationInfo>
)
data class LocationInfo(
    val street : String,
    val city : String
)
 */
