package com.dev.anhnd.android_mvvm_di_hilt.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dev.anhnd.android_mvvm_di_hilt.data.source.local.entity.Notes


class MainViewModel @ViewModelInject constructor() : ViewModel() {

    val note by lazy {
        MutableLiveData<Notes>()
    }
}
