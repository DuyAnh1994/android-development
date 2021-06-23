package com.dev.anhnd.android_mvvm_di_hilt.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.anhnd.android_mvvm_di_hilt.data.model.FoodMenu
import com.dev.anhnd.android_mvvm_di_hilt.data.repository.FoodRepository
import com.dev.anhnd.android_mvvm_di_hilt.data.source.local.entity.Notes
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class MainViewModel @ViewModelInject constructor(
    private val foodRepository: FoodRepository
) : ViewModel() {

    val note by lazy {
        MutableLiveData<Notes>()
    }

    val menu by lazy {
        MutableLiveData<List<FoodMenu>>()
    }

    fun getMenu() {
        viewModelScope.launch {
            foodRepository.getAllNotes().collect {
                menu.postValue(it)
            }
        }
    }
}
