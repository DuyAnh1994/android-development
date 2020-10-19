package com.dev.anhnd.android_mvvm_di.data.remote

import com.dev.anhnd.android_mvvm_di.model.User
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>
}