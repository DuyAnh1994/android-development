package com.dev.anhnd.android_mvvm.ui.main

import android.os.Bundle
import com.dev.anhnd.android_mvvm.R
import com.dev.anhnd.android_mvvm.databinding.ActivityMainBinding
import com.dev.anhnd.mybase.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun getLayoutId(): Int = R.layout.activity_main

    override fun setup() {
    }

    override fun initView() {

    }

    override fun observerViewModel() {

    }
}

