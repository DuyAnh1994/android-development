package com.dev.anhnd.android_web_service.data.model.account

import com.google.gson.annotations.SerializedName

data class Account(
    @SerializedName("avatar")
    val avatar: Avatar,
    @SerializedName("id")
    val id: Int,
    @SerializedName("include_adult")
    val include_adult: Boolean,
    @SerializedName("iso_3166_1")
    val iso_3166_1: String,
    @SerializedName("iso_639_1")
    val iso_639_1: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String
)