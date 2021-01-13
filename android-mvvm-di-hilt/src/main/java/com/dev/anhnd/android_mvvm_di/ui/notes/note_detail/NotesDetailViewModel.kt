package com.dev.anhnd.android_mvvm_di.ui.notes.note_detail

import androidx.hilt.lifecycle.ViewModelInject
import com.dev.anhnd.android_mvvm_di.repository.NotesRepository
import com.dev.anhnd.mybase.BaseViewModel

class NotesDetailViewModel @ViewModelInject constructor(
    private val notesRepository: NotesRepository
) : BaseViewModel() {

}
