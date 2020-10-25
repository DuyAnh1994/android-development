package com.dev.anhnd.android_mvvm_di.repository

import com.dev.anhnd.android_mvvm_di.data.remote.ApiHelper

//class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {
class MainRepository constructor(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()

}