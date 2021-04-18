package com.dev.anhnd.android_note_todos.data.source.remote

import com.dev.anhnd.android_note_todos.data.model.Note
import retrofit2.http.*

interface ApiService {

    @GET("/note/findAll")
    suspend fun findAll(): MutableList<Note>

    @GET("/note/findById/")
    suspend fun findById(@Query("id") id: String): Note

    @POST("/note/create")
    suspend fun create(@Body note: Note): Note

    @PUT("/note/update")
    suspend fun update(@Body note: Note): Note

    @DELETE("/note/delete/")
    suspend fun delete(@Query("id") id: String)

    @DELETE("/note/deleteAll")
    suspend fun deleteAll()
}
