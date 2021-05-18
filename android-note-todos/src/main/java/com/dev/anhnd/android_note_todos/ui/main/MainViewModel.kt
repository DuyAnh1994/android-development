package com.dev.anhnd.android_note_todos.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dev.anhnd.android_note_todos.data.model.Note
import com.dev.anhnd.android_note_todos.data.repository.NoteRepository
import com.dev.anhnd.android_note_todos.domain.note.NoteUserCase
import com.dev.anhnd.mybase.BaseViewModel
import com.dev.anhnd.mybase.utils.app.asLiveData
import com.dev.anhnd.mybase.utils.app.onCollectPostValue
import com.dev.anhnd.mybase.utils.clean_architecture.BaseResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val noteUserCase: NoteUserCase
) : BaseViewModel() {

    private val _note = MutableLiveData<BaseResponse<Note>>()
    val note = _note.asLiveData()

    fun getNote(id: String) {
        viewModelScope.launch {
            noteUserCase.invoke(id).onCollectPostValue(_note)
        }
    }



}