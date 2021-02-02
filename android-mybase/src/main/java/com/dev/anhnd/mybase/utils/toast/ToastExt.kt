package com.dev.anhnd.mybase.utils.toast

import android.content.Context
import android.widget.Toast
import com.dev.anhnd.mybase.utils.app.getApplication
import com.dev.anhnd.mybase.utils.app.runOnMainThread

fun Any.toast(message: String) {
    runOnMainThread({
        Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show()
    })
}

fun Any.longToast(message: String) {
    runOnMainThread({
        Toast.makeText(getApplication(), message, Toast.LENGTH_LONG).show()
    })
}