package com.dev.anhnd.android_mvvm_di_hilt.ui.notes.add_notes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dev.anhnd.android_mvvm_di_hilt.data.repository.NotesRepository
import com.dev.anhnd.android_mvvm_di_hilt.data.source.local.entity.Notes
import com.dev.anhnd.mybase.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AddNotesViewModel @Inject constructor(
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
