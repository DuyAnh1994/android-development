package com.dev.anhnd.android_mvvm_di_hilt.data.source.remote

import com.dev.anhnd.android_mvvm_di_hilt.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}