package com.dev.anhnd.mybase.utils.log

import android.app.Activity
import android.util.Log
import androidx.fragment.app.Fragment

var APPLOG = "APP_LOG "

private val logEnable = true

//region logd debug
private fun Activity.d(message: Any) {
    if (logEnable) {
        Log.d(APPLOG + this::class.java.simpleName, message.toString())
    }
}

fun Activity.logd(message: Any) {
    d(message)
}
private fun Fragment.d(message: Any) {
    if (logEnable) {
        Log.d(APPLOG + this::class.java.simpleName, message.toString())
    }
}

fun Fragment.logd(message: Any) {
    d(message)
}
//endregion

//region log error
private fun Fragment.e(message: Any) {
    if (logEnable) {
        Log.e(APPLOG + this::class.java.simpleName, message.toString())
    }
}

fun Fragment.loge(message: Any) {
    e(message)
}
//endregion



//region log verbose
private fun Fragment.v(message: Any) {
    if (logEnable) {
        Log.v(APPLOG + this::class.java.simpleName, message.toString())
    }
}

fun Fragment.logv(message: Any) {
    v(message)
}
//endregion

//region log info
private fun Fragment.i(message: Any) {
    if (logEnable) {
        Log.i(APPLOG + this::class.java.simpleName, message.toString())
    }
}

fun Fragment.logi(message: Any) {
    i(message)
}
//endregion

//region log warning
private fun Fragment.w(message: Any) {
    if (logEnable) {
        Log.w(APPLOG + this::class.java.simpleName, message.toString())
    }
}

fun Fragment.logw(message: Any) {
    w(message)
}
//endregion

//region log big error
private fun Fragment.wtf(message: Any) {
    if (logEnable) {
        Log.wtf(APPLOG + this::class.java.simpleName, message.toString())
    }
}

fun Fragment.logwtf(message: Any) {
    wtf(message)
}
//endregion
