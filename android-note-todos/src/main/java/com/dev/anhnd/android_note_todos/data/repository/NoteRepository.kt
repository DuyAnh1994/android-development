package com.dev.anhnd.android_note_todos.data.repository

import com.dev.anhnd.android_note_todos.data.model.Note
import com.dev.anhnd.android_note_todos.data.source.remote.ApiService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NoteRepository @Inject constructor(private val service: ApiService)  {

    suspend fun findAll(): MutableList<Note> = service.findAll()

    suspend fun findById(id: String): Note = service.findById(id)

//        fun findAll() = flow {
//        emit(service.findAll())
//    }

//    fun findById(id: String) = flow {
//        emit(service.findById(id))
//    }

    fun createNote(note: Note) = flow {
        emit(service.create(note))
    }

    fun updateNote(note: Note) = flow {
        emit(service.update(note))
    }

    fun delete(id: String) = flow {
        emit(service.delete(id))
    }

    fun deleteAll() = flow {
        emit(service.deleteAll())
    }


}