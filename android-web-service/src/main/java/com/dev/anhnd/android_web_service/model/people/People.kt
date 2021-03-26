package com.dev.anhnd.android_web_service.model.people

data class People(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)