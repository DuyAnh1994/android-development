package com.dev.anhnd.android_mvvm_di_hilt.data.model

import com.google.gson.annotations.SerializedName

data class FoodMenu(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("image")
    val image: String,
)