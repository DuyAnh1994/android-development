package com.dev.anhnd.android_web_service.data.model.account

import com.google.gson.annotations.SerializedName

data class Gravatar(
    @SerializedName("hash")
    val hash: String
)