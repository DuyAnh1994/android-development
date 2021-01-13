package com.dev.anhnd.android_mvvm_di.repository

import androidx.lifecycle.MutableLiveData
import com.dev.anhnd.android_mvvm_di.data.remote.ApiHelper
import com.dev.anhnd.android_mvvm_di.model.User
import com.dev.anhnd.android_mvvm_di.utils.Event
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import javax.inject.Inject

@Module
@InstallIn(ActivityRetainedComponent::class)
class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {
//class MainRepository constructor(private val apiHelper: ApiHelper) {

    val users = MutableLiveData<Event<List<User>>>()

    suspend fun getUsers(hideLoading:()->Unit) {
        apiHelper.getUsers().let {
            if (it.isSuccessful) {
                users.postValue(Event.success(it.body()))
            } else {
                users.postValue(Event.error(null, it.errorBody().toString()))
            }
            hideLoading.invoke()
        }
    }
}