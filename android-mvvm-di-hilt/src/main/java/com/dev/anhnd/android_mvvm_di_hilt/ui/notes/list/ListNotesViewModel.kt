package com.dev.anhnd.android_mvvm_di_hilt.ui.notes.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.dev.anhnd.android_mvvm_di_hilt.data.repository.NotesRepository
import com.dev.anhnd.android_mvvm_di_hilt.data.source.local.entity.Notes
import com.dev.anhnd.mybase.BaseViewModel
import com.dev.anhnd.mybase.utils.work.viewModelDoJob
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListNotesViewModel @Inject constructor(
    private val notesRepository: NotesRepository
) : BaseViewModel() {

    val notes = notesRepository.getAllNotes()

    fun delete(note: Notes) {
        viewModelDoJob(
            doIn = {
                notesRepository.delete(note)
            }
        )
    }
}
