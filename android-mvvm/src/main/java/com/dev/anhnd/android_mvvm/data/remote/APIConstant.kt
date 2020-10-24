package com.dev.anhnd.android_mvvm.data.remote

object APIConstant {

    const val BASE_URL = "https://5e510330f2c0d300147c034c.mockapi.io/"

    /**
     * this method get instance APIService
     */
    fun getData() = RetrofitClient.getClient(BASE_URL)?.create(ApiService::class.java)
}