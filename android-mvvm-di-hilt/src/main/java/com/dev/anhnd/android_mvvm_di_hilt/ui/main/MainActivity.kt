package com.dev.anhnd.android_mvvm_di_hilt.ui.main

import com.dev.anhnd.android_mvvm_di_hilt.R
import com.dev.anhnd.android_mvvm_di_hilt.databinding.ActivityMainBinding
import com.dev.anhnd.mybase.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val TAG = MainActivity::class.java.simpleName

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initBinding() {

    }

    override fun initView() {

    }

    override fun observerViewModel() {

    }
}
