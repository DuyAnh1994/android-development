package com.dev.anhnd.android_web_service.data.source.repository

import com.dev.anhnd.android_web_service.data.source.remote.ApiService
import com.dev.anhnd.android_web_service.utils.Constant
import kotlinx.coroutines.flow.flow

class PeopleRepository(private val service: ApiService) {

    fun getPopular(apiKey: String,
                   language: String = Constant.LANGUAGE_VI,
                   page: String = Constant.PAGE) = flow {
        emit(service.getPeoplePopular(apiKey, language, page))
    }
}


