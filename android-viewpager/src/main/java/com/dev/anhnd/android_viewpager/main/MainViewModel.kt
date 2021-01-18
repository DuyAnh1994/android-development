package com.dev.anhnd.android_viewpager.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dev.anhnd.mybase.BaseViewModel

class MainViewModel : BaseViewModel() {

    private val TAG = MainViewModel::class.java.simpleName

    val liveText by lazy {
        MutableLiveData<String>("init")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared")
        liveText.value = "init"
    }


}