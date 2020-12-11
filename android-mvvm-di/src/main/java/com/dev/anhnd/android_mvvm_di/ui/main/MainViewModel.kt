package com.dev.anhnd.android_mvvm_di.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.anhnd.android_mvvm_di.repository.MainRepository
import kotlinx.coroutines.launch

//class MainViewModel @ViewModelInject constructor(
class MainViewModel constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    val user by lazy {
        mainRepository.users
    }

    var isLoading = MutableLiveData(false)

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            isLoading.postValue(true)
            mainRepository.getUsers {
                isLoading.postValue(false)
            }
        }
    }
}