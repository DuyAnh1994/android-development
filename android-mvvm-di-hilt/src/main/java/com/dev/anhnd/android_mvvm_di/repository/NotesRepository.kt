package com.dev.anhnd.android_mvvm_di.repository

import com.dev.anhnd.android_mvvm_di.data.local.notes.Notes
import com.dev.anhnd.android_mvvm_di.data.local.notes.NotesDao
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@Module
@InstallIn(ActivityRetainedComponent::class)
class NotesRepository @Inject constructor(private val notesDao: NotesDao) {

    fun insert(notes: Notes) = notesDao.insert(notes)

    fun update(notes: Notes) = notesDao.update(notes)

    fun delete(notes: Notes) = notesDao.delete(notes)

    fun getAllNotes(): Flow<MutableList<Notes>> = notesDao.getAllNotes()

    fun getNotesByTitle(title: String): Flow<List<Notes>> = notesDao.getNotesByTitle(title)
}
