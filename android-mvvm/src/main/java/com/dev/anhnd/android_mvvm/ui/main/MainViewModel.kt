package com.dev.anhnd.android_mvvm.ui.main

import androidx.lifecycle.viewModelScope
import com.dev.anhnd.android_mvvm.repository.MainRepository
import com.dev.anhnd.mybase.BaseViewModel
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainRepository: MainRepository
) : BaseViewModel() {

    val users = mainRepository.users

    fun fetchUsers() {
        viewModelScope.launch {
            mainRepository.fetchUsers({}, {})
        }
    }
}