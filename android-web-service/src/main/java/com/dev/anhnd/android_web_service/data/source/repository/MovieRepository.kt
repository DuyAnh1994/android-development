package com.dev.anhnd.android_web_service.data.source.repository

import com.dev.anhnd.android_web_service.data.source.remote.ApiService
import com.dev.anhnd.android_web_service.utils.Constant
import kotlinx.coroutines.flow.flow

class MovieRepository(private val service: ApiService) {

    fun getNowPlaying(apiKey: String,
                      language: String = Constant.LANGUAGE_VI,
                      page: String = Constant.PAGE) = flow {
        emit(service.getMovieNowPlaying(apiKey, language, page))
    }

    fun getPopular(apiKey: String,
                   language: String = Constant.LANGUAGE_VI,
                   page: String = Constant.PAGE) = flow {
        emit(service.getMoviePopular(apiKey, language, page))
    }

    fun getTopRated(apiKey: String,
                    language: String = Constant.LANGUAGE_VI,
                    page: String = Constant.PAGE) = flow {
        emit(service.getMovieTopRated(apiKey, language, page))
    }

    fun getUpcoming(apiKey: String,
                    language: String = Constant.LANGUAGE_VI,
                    page: String = Constant.PAGE) = flow {
        emit(service.getMovieUpcoming(apiKey, language, page))
    }
}
