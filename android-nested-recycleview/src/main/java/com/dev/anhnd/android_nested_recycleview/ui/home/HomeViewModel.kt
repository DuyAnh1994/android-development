package com.dev.anhnd.android_nested_recycleview.ui.home

import androidx.hilt.Assisted
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.dev.anhnd.android_nested_recycleview.model.Continents
import com.dev.anhnd.android_nested_recycleview.utils.DataUtils
import com.dev.anhnd.mybase.BaseViewModel
import com.dev.anhnd.mybase.utils.app.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class HomeViewModel @Inject constructor(
    @Assisted private val state: SavedStateHandle
) : BaseViewModel() {

    private val _continents = MutableLiveData(mutableListOf<Continents>())
    val continents = _continents.asLiveData()
    val liveState = state.getLiveData("liveData", Random.nextInt().toString())

    fun getContinents() {
        _continents.value = DataUtils.continents
    }

    fun saveState() {
        state.set("liveData", liveState.value)
    }
}