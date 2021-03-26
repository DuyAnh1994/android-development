package com.dev.anhnd.mybase.utils.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


fun <T> Call<T>.getResult(onSuccess: (T) -> Unit, onFail: (message: String) -> Unit = {}) {
    enqueue(object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            response.body()?.let {
                onSuccess.invoke(it)
            } ?: run {
                onFail.invoke("Response null")
            }

        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            onFail.invoke(t.message!!)
        }
    })
}

suspend fun <T> Call<T>.waitResponse(onFail: (message: String) -> Unit = {}): T {
    return suspendCoroutine { continuation ->
        enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                response.body()?.let {
                    if (response.isSuccessful) {
                        continuation.resume(it)
                    } else {
                        onFail.invoke("Api error!")
                        /*try {
                            val dataObj = Gson().fromJson(JsonParser().parse(response.errorBody()?.toString()), clazz)
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }*/
                    }
                } ?: run {
                    onFail.invoke("Response null!")
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                onFail.invoke(t.message!!)

            }
        })
    }
}
