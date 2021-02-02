package com.dev.anhnd.android_mvvm_di.ui.notes.list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.dev.anhnd.android_mvvm_di.data.local.notes.Notes
import com.dev.anhnd.android_mvvm_di.repository.NotesRepository
import com.dev.anhnd.mybase.BaseViewModel
import com.dev.anhnd.mybase.utils.work.viewModelDoJob

class ListNotesViewModel @ViewModelInject constructor(
    private val notesRepository: NotesRepository
) : BaseViewModel() {

    val notes: LiveData<List<Notes>> by lazy {
        notesRepository.getAllNotes().asLiveData()
    }

    fun delete(note:Notes) {
        viewModelDoJob(
            doIn =  {
                notesRepository.delete(note)
            }
        )
    }
}
