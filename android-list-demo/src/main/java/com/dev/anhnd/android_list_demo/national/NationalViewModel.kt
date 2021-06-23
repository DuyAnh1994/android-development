package com.dev.anhnd.android_list_demo.national

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dev.anhnd.android_list_demo.utils.DataUtils
import com.dev.anhnd.mybase.utils.app.postSelf

class NationalViewModel : ViewModel() {

    val liveNationals by lazy {
        MutableLiveData(mutableListOf<National>())
    }

    fun getList() {
        liveNationals.value = DataUtils.nationals
    }

    fun remove(national: National) {
        liveNationals.value?.remove(national)
    }

    fun postSelf(onSuccess : (a: Int, b: Boolean) -> Unit) {
        liveNationals.postSelf()
    }
}
