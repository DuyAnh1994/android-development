package com.dev.anhnd.android_web_service.utils

import com.dev.anhnd.android_web_service.data.model.ApiDetail
import com.dev.anhnd.android_web_service.data.model.ApiType

object DataUtils {
    val apiType = mutableListOf(
        ApiType(Constant.API_TYPE_ACCOUNT),
        ApiType(Constant.API_TYPE_AUTHENTICATION),
        ApiType(Constant.API_TYPE_CERTIFICATIONS),
        ApiType(Constant.API_TYPE_CHANGES),
        ApiType(Constant.API_TYPE_COMPANIES),
        ApiType(Constant.API_TYPE_CONFIGURATION),
        ApiType(Constant.API_TYPE_CREDITS),
        ApiType(Constant.API_TYPE_DISCOVER),
        ApiType(Constant.API_TYPE_FIND),
        ApiType(Constant.API_TYPE_GENRES),
        ApiType(Constant.API_TYPE_GUEST_SESSION),
        ApiType(Constant.API_TYPE_KEYWORDS),
        ApiType(Constant.API_TYPE_LISTS),
        ApiType(Constant.API_TYPE_MOVIES),
        ApiType(Constant.API_TYPE_NETWORKS),
        ApiType(Constant.API_TYPE_TRENDING),
        ApiType(Constant.API_TYPE_PEOPLE),
        ApiType(Constant.API_TYPE_REVIEWS),
        ApiType(Constant.API_TYPE_SEARCH),
        ApiType(Constant.API_TYPE_TV),
        ApiType(Constant.API_TYPE_TV_SEASON),
        ApiType(Constant.API_TYPE_TV_EPISODES),
        ApiType(Constant.API_TYPE_TV_EPISODE_GROUP),
    )

    val apiMovies = mutableListOf(
        ApiDetail(Constant.API_DETAIL_MOVIES_GET_NOW_PLAYING),
        ApiDetail(Constant.API_DETAIL_MOVIES_GET_POPULAR),
        ApiDetail(Constant.API_DETAIL_MOVIES_GET_TOP_RATED),
        ApiDetail(Constant.API_DETAIL_MOVIES_GET_UPCOMING),
    )

    val apiPeople = mutableListOf(
        ApiDetail(Constant.API_DETAIL_PEOPLE_GET_POPULAR)
    )
}