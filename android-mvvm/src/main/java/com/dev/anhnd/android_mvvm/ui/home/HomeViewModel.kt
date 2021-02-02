package com.dev.anhnd.android_mvvm.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.dev.anhnd.android_mvvm.model.Photos
import com.dev.anhnd.android_mvvm.repository.HomeRepository
import com.dev.anhnd.mybase.BaseViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import java.util.concurrent.Future

class HomeViewModel @ViewModelInject constructor(
    private val homeRepository: HomeRepository
) : BaseViewModel() {

    private val _photos by lazy {
        MutableLiveData<List<Photos>>()
    }

    val photos: LiveData<List<Photos>> = liveData {
        homeRepository.getPhotos().collect {
            emit(it)
        }
    }
}
