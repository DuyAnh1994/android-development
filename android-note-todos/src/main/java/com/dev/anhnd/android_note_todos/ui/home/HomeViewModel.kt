package com.dev.anhnd.android_note_todos.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dev.anhnd.android_note_todos.data.model.Note
import com.dev.anhnd.android_note_todos.domain.note.ListNoteUserCase
import com.dev.anhnd.mybase.BaseViewModel
import com.dev.anhnd.mybase.utils.app.asLiveData
import com.dev.anhnd.mybase.utils.app.onCollectPostValue
import com.dev.anhnd.mybase.utils.clean_architecture.BaseResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val listNoteUserCase: ListNoteUserCase
) : BaseViewModel() {

    private val _notes = MutableLiveData<BaseResponse<MutableList<Note>>>()
    val notes = _notes.asLiveData()

    fun getNotes() {
        viewModelScope.launch {
            listNoteUserCase.invoke(Unit).onCollectPostValue(_notes)
        }
    }
}
