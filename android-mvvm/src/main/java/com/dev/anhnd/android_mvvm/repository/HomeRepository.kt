package com.dev.anhnd.android_mvvm.repository

import com.dev.anhnd.android_mvvm.data.remote.ApiService
import com.dev.anhnd.android_mvvm.model.Photos
import com.dev.anhnd.android_mvvm.utils.waitResponse
import com.dev.anhnd.mybase.utils.log.loge
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

class HomeRepository  constructor(private val apiService: ApiService) {

    suspend fun getPhotos() =apiService.getPhotos().waitResponse()
}
