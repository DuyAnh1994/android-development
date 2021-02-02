package com.dev.anhnd.android_mvvm.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dev.anhnd.android_mvvm.model.Photos
import com.dev.anhnd.android_mvvm.repository.HomeRepository
import com.dev.anhnd.mybase.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val homeRepository: HomeRepository
) : BaseViewModel() {

    private val _photos by lazy {
        MutableLiveData<List<Photos>>()
    }

    val photos: LiveData<List<Photos>> = _photos

    fun getPhotos() {
        viewModelScope.launch {
            _photos.postValue(homeRepository.getPhotos())
        }
    }
}
