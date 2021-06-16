package com.dev.anhnd.android_bottom_navigation_view.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dev.anhnd.mybase.utils.app.asLiveData

class MainViewModel: ViewModel() {

    private val _liveShowMenu by lazy {
        MutableLiveData(false)
    }

    fun showMenu() {
        _liveShowMenu.postValue(true)
    }

    fun hideMenu() {
        _liveShowMenu.postValue(false)
    }

    fun getLiveMenu() = _liveShowMenu.asLiveData()
}