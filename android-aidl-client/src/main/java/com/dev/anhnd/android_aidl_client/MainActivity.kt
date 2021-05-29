package com.dev.anhnd.android_aidl_client

import android.content.ComponentName
import android.content.Context
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    private lateinit var addService: IAdd


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectionToService()
    }

    private fun connectionToService() {
        val connection = object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                addService = IAdd.Stub.asInterface(service)
                Log.d(TAG, "connecting...")
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                Log.d(TAG, "disconnect...")
            }
        }
        val connected = bindService(ServiceIntentBuilder.buildAudioPlayerBindIntent(), connection, Context.BIND_AUTO_CREATE)
        Log.d(TAG, "connection initiated: $connected")
    }
}