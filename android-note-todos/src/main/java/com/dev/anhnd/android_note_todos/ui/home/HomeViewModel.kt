package com.dev.anhnd.android_note_todos.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dev.anhnd.android_note_todos.data.model.Note
import com.dev.anhnd.android_note_todos.data.repository.NoteRepository
import com.dev.anhnd.mybase.BaseViewModel
import com.dev.anhnd.mybase.utils.app.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val noteRepository: NoteRepository
) : BaseViewModel() {

    private val _notes = MutableLiveData<MutableList<Note>>()
    val notes = _notes.asLiveData()

    fun getNotes() {
        viewModelScope.launch {
            noteRepository.findAll().collect { notes ->
                _notes.postValue(notes)
            }
        }
    }




}