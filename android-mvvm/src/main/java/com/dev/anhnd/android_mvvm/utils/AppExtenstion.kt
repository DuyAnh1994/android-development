package com.dev.anhnd.android_mvvm.utils

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun <T> Call<T>.waitResponse(onError: (Throwable) -> Unit, onHideLoading: () -> Unit): T? {
    return suspendCoroutine { continuation ->
        enqueue(object : Callback<T> {
            override fun onFailure(call: Call<T>, t: Throwable) {
                onError.invoke(t)
                onHideLoading.invoke()
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                onHideLoading.invoke()
                if (response.isSuccessful) {
                    continuation.resume(response.body()!!)
                } else {

                }
            }
        })
    }
}