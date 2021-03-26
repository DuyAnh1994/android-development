package com.dev.anhnd.android_web_service.model.account

import com.google.gson.annotations.SerializedName

data class Avatar(
    @SerializedName("gravatar")
    val gravatar: Gravatar
)