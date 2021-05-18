package com.dev.anhnd.android_mvvm_di_hilt.ui.main

import com.dev.anhnd.android_mvvm_di_hilt.R
import com.dev.anhnd.android_mvvm_di_hilt.databinding.ActivityMainBinding
import com.dev.anhnd.mybase.BaseActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import io.sentry.Sentry

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    companion object {
        private val x = "x"
        private const val y = "y"
    }

    private lateinit var firebaseAnalytics : FirebaseAnalytics

    private  val TAG = MainActivity::class.java.simpleName

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initBinding() {

    }


    override fun initView() {
        firebaseAnalytics = Firebase.analytics
    }

    override fun observerViewModel() {

    }
}
