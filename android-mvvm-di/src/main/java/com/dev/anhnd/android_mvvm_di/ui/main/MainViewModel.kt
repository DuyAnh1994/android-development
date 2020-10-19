package com.dev.anhnd.android_mvvm_di.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.anhnd.android_mvvm_di.model.User
import com.dev.anhnd.android_mvvm_di.repository.MainRepository
import com.dev.anhnd.android_mvvm_di.utils.Event
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {


    private val _users = MutableLiveData<Event<List<User>>>()
    val user: LiveData<Event<List<User>>>
        get() = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _users.postValue(Event.loading(null))
            mainRepository.getUsers().let {
                if (it.isSuccessful) {
                    _users.postValue(Event.success(it.body()))
                } else {
                    _users.postValue(Event.error(null, it.errorBody().toString()))
                }
            }
        }
    }
}