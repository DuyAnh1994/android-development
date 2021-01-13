package com.dev.anhnd.android_mvvm_di.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dev.anhnd.android_mvvm_di.data.local.notes.Notes

class MainViewModel @ViewModelInject constructor() : ViewModel() {

    val note by lazy {
        MutableLiveData<Notes>()
    }
}
