package com.dev.anhnd.android_note_todos.data.model

import com.google.gson.annotations.SerializedName


data class Note(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("isDone")
    val isDone: String = ""
)