package com.dev.anhnd.android_mvvm_di_hilt.data.repository

import com.dev.anhnd.android_mvvm_di_hilt.data.source.local.dao.NotesDao
import com.dev.anhnd.android_mvvm_di_hilt.data.source.local.entity.Notes
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NotesRepository @Inject constructor(private val notesDao: NotesDao) {

    fun insert(notes: Notes) = notesDao.insert(notes)

    fun update(notes: Notes) = notesDao.update(notes)

    fun delete(notes: Notes) = notesDao.delete(notes)

    fun getAllNotes(): Flow<MutableList<Notes>> = notesDao.getAllNotes()

    fun getNotesByTitle(title: String): Flow<List<Notes>> = notesDao.getNotesByTitle(title)
}
