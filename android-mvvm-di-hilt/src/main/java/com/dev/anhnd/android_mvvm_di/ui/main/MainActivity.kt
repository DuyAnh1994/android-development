package com.dev.anhnd.android_mvvm_di.ui.main

import android.os.Bundle
import android.view.View
import com.dev.anhnd.android_mvvm_di.R
import com.dev.anhnd.android_mvvm_di.databinding.ActivityMainBinding
import com.dev.anhnd.mybase.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val TAG = MainActivity::class.java.simpleName

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initBinding() {

    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {

    }

    override fun observerViewModel() {

    }
}
