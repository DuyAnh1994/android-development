package com.dev.anhnd.android_note_todos.data.source.remote

import com.dev.anhnd.android_note_todos.data.model.Note
import retrofit2.http.*

interface ApiService {

    @GET("/note/")
    suspend fun findAll(): MutableList<Note>
//    suspend fun findAll(): BaseResponse<MutableList<Note>>

    @GET("/note/{id}")
    suspend fun findById(@Path("id") id: String): Note
//    suspend fun findById(@Query("id") id: String): Note

    @POST("/note/create")
    suspend fun create(@Body note: Note): Note

    @PUT("/note/update")
    suspend fun update(@Body note: Note): Note

    @DELETE("/note/delete/")
    suspend fun delete(@Query("id") id: String)

    @DELETE("/note/deleteAll")
    suspend fun deleteAll()
}
