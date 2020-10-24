package com.dev.anhnd.android_mvvm.data.remote

import com.dev.anhnd.android_mvvm.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET(APIConstant.BASE_URL + "users")
    fun getUsers(): Call<List<User>>
}