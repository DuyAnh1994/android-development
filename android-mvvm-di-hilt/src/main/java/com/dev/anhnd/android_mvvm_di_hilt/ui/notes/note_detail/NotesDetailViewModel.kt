package com.dev.anhnd.android_mvvm_di_hilt.ui.notes.note_detail

import androidx.hilt.lifecycle.ViewModelInject
import com.dev.anhnd.android_mvvm_di_hilt.data.repository.NotesRepository
import com.dev.anhnd.mybase.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesDetailViewModel @Inject constructor(
    private val notesRepository: NotesRepository
) : BaseViewModel() {

}
