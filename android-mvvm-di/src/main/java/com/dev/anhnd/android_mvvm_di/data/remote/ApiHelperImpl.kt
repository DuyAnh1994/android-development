package com.dev.anhnd.android_mvvm_di.data.remote

import com.dev.anhnd.android_mvvm_di.model.User
import retrofit2.Response

//class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
class ApiHelperImpl constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUsers(): Response<List<User>> = apiService.getUsers()

}