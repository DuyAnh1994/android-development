package com.dev.anhnd.android_mvvm_di_hilt.data.repository

import com.dev.anhnd.android_mvvm_di_hilt.data.source.remote.ApiService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FoodRepository @Inject constructor(private val service: ApiService) {

    suspend fun getAllNotes() = flow {
        emit(service.getMenu())
    }

}