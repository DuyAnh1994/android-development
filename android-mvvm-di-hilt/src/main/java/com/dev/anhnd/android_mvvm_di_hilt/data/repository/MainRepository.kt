package com.dev.anhnd.android_mvvm_di_hilt.data.repository

import androidx.lifecycle.MutableLiveData
import com.dev.anhnd.android_mvvm_di_hilt.data.model.User
import com.dev.anhnd.android_mvvm_di_hilt.data.source.remote.ApiService
import com.dev.anhnd.android_mvvm_di_hilt.utils.Event
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import javax.inject.Inject

class MainRepository @Inject constructor(private val service: ApiService) {

//    val users = MutableLiveData<Event<List<User>>>()

//    suspend fun getUsers(hideLoading:()->Unit) {
//        service.getUsers().let {
//            if (it.isSuccessful) {
//                users.postValue(Event.success(it.body()))
//            } else {
//                users.postValue(Event.error(null, it.errorBody().toString()))
//            }
//            hideLoading.invoke()
//        }
//    }
}