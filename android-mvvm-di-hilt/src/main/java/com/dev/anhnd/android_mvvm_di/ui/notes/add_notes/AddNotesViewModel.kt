package com.dev.anhnd.android_mvvm_di.ui.notes.add_notes

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dev.anhnd.android_mvvm_di.data.local.notes.Notes
import com.dev.anhnd.android_mvvm_di.repository.NotesRepository
import com.dev.anhnd.mybase.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddNotesViewModel @ViewModelInject constructor(
    private val notesRepository: NotesRepository
) : BaseViewModel() {

    val liveTextTitle by lazy {
        MutableLiveData<String>("")
    }

    val liveTextContent by lazy {
        MutableLiveData<String>("")
    }

    fun addNotes(notes: Notes, onSuccess: () -> Unit) {
        viewModelScope.launch {
            notesRepository.insert(notes)
            withContext(Dispatchers.Main) {
                onSuccess.invoke()
            }
        }
    }
}
