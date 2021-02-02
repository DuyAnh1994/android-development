package com.dev.anhnd.android_mvvm.repository

import com.dev.anhnd.android_mvvm.data.remote.ApiService
import com.dev.anhnd.android_mvvm.model.Photos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject constructor(private val apiService: ApiService) {

    fun getPhotos(): Flow<List<Photos>> {
        return flow {
            apiService.getPhotos()
        }
    }
}
