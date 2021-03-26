package com.dev.anhnd.android_web_service.data.remote


import com.dev.anhnd.android_web_service.model.movies.Movies
import com.dev.anhnd.android_web_service.model.people.People
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/3/movie/now_playing")
    suspend fun getMovieNowPlaying(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: String,
    ): Movies

    @GET("/3/movie/popular")
    suspend fun getMoviePopular(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: String,
    ): Movies

    @GET("/3/movie/top_rated")
    suspend fun getMovieTopRated(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: String,
    ): Movies

    @GET("/3/movie/upcoming")
    suspend fun getMovieUpcoming(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: String,
    ): Movies

    @GET("/3/person/popular")
    suspend fun getPeoplePopular(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "en-US",
        @Query("page") page: String = "1",
    ): People
}
