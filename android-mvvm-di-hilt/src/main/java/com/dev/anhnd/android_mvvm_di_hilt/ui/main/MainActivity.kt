package com.dev.anhnd.android_mvvm_di_hilt.ui.main

import android.util.Log
import androidx.activity.viewModels
import com.dev.anhnd.android_mvvm_di_hilt.R
import com.dev.anhnd.android_mvvm_di_hilt.databinding.ActivityMainBinding
import com.dev.anhnd.mybase.BaseActivity
import com.dev.anhnd.mybase.utils.app.observer
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    companion object {
        private val x = "x"
        private const val y = "y"
    }

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    private val TAG = MainActivity::class.java.simpleName

    private val mainViewModel by viewModels<MainViewModel>()

    private val adapter by lazy {

    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initBinding() {

    }


    override fun initView() {
        firebaseAnalytics = Firebase.analytics
        mainViewModel.getMenu()
    }

    override fun observerViewModel() {
        observer(mainViewModel.menu) {
            Log.d(TAG, "menu: ${it?.toString()}")
        }
    }
}
