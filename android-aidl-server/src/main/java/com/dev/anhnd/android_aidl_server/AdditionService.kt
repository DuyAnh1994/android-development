package com.dev.anhnd.android_aidl_server

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class AdditionService : Service() {

    private val TAG = AdditionService::class.java.simpleName

    override fun onBind(intent: Intent?): IBinder {
        Log.d(TAG, "onBind")
        return binder
    }

    private val binder = object : IAdd.Stub() {
        override fun addNumber(first: Int, two: Int) = first + two
    }

}