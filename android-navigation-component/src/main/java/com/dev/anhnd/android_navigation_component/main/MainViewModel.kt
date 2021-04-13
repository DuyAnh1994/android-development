package com.dev.anhnd.android_navigation_component.main

import androidx.lifecycle.MutableLiveData
import com.dev.anhnd.mybase.BaseViewModel
import com.dev.anhnd.mybase.utils.app.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {

    private val TAG = MainViewModel::class.java.simpleName

    private val _liveShowMenu by lazy {
        MutableLiveData(true)
    }

    val liveText by lazy {
        MutableLiveData<String>("init")
    }

    fun showMenu() {
        _liveShowMenu.value = true
    }

    fun hideMenu() {
        _liveShowMenu.value = false
    }

    fun getLiveMenu() = _liveShowMenu.asLiveData()

    public override fun onCleared() {
        super.onCleared()
        liveText.value = "init"
    }
}