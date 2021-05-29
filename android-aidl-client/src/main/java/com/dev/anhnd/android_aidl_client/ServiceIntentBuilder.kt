package com.dev.anhnd.android_aidl_client

import android.content.Intent

object ServiceIntentBuilder {

    const val ACTION = "com.dev.anhnd.android_aidl_server.AdditionService.BIND"
    const val PACKAGE = "com.dev.anhnd.android_aidl_server"

    fun buildAudioPlayerBindIntent() : Intent {
        return Intent(ACTION).setPackage(PACKAGE)
    }
}