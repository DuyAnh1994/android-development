package com.dev.anhnd.android_mvvm.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.dev.anhnd.android_mvvm.model.Color
import com.dev.anhnd.android_mvvm.model.Image
import com.dev.anhnd.android_mvvm.model.Text
import com.dev.anhnd.mybase.utils.adapter.BaseMultiHolderAdapter
import org.json.JSONException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.net.ssl.SSLHandshakeException
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun <T> Call<T>.waitResponse(onSuccess: () -> Unit={}, onFail: (message: String) -> Unit= {}): T? {
    return suspendCoroutine { continuation ->
        var message = "Unknown error"
        enqueue(object : Callback<T> {
            override fun onFailure(call: Call<T>, t: Throwable) {
                when (t) {
                    is HttpException -> {
                        message = "Server error!"
                    }
                    is SSLHandshakeException -> {
                        message = "Wrong date on phone. Please check again!"
                    }
                    is IOException -> {
                        message = "Network error!"
                    }
                    is JSONException -> {
                        message = "Data parse error!"
                    }
                }
                onFail.invoke(message)
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    continuation.resume(response.body()!!)
                    onSuccess.invoke()
                }
            }
        })
    }
}

@BindingAdapter("ivLoadBackgroundById")
fun ImageView.imgLoadColorById(id: Int) {
    setBackgroundResource(id)
}

@BindingAdapter("tv_set_text_by_multi_holder")
fun TextView.tvSetTextByMultiHolder(item: BaseMultiHolderAdapter.BaseModelType) {
    if (item is Text) {
        text = item.text
    }
}

@BindingAdapter("tv_set_color_by_multi_holder")
fun ImageView.ivSetColorByMultiHolder(item: BaseMultiHolderAdapter.BaseModelType) {
    if (item is Color) {
        setBackgroundResource(item.color)
    }
}

@BindingAdapter("tv_set_image_by_multi_holder")
fun ImageView.tvSetImageByMultiHolder(item: BaseMultiHolderAdapter.BaseModelType) {
    if (item is Image) {
        setBackgroundResource(item.image)
    }
}
