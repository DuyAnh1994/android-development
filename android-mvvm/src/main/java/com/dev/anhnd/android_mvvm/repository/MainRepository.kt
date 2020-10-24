package com.dev.anhnd.android_mvvm.repository

import androidx.lifecycle.MutableLiveData
import com.dev.anhnd.android_mvvm.data.remote.APIConstant
import com.dev.anhnd.android_mvvm.model.User
import com.dev.anhnd.android_mvvm.utils.waitResponse
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class MainRepository {

    private val apiService = APIConstant.getData()!!

    val users = MutableLiveData<List<User>>()

    companion object {
        @Volatile
        private var instance: MainRepository? = null

        @Synchronized
        fun getInstance(): MainRepository {
            if (instance == null) {
                instance = MainRepository()
            }
            return instance!!
        }

        fun clear() {
            instance = null
        }
    }

    suspend fun fetchUsers(onError: () -> Unit, onHideLoading: () -> Unit) {
        // cách 1 : sử dụng để tránh việc bất đồng bộ và có thể đợi hoàn thành xong call api r mới return giá trị
        val result = apiService.getUsers().waitResponse({
            onError.invoke()
        }, {
            onHideLoading.invoke()
        })
        users.postValue(result)

        // cách 2 : Có thể gặp lỗi ở mà cách 1 đã khắc phục, công việc nặng nên gọi trong coroutines
        /*apiService.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                users.value = response.body()
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

            }
        })*/
    }
}