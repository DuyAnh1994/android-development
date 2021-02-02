package com.dev.anhnd.android_coroutines_flow.ui.main

import android.os.Bundle
import android.view.View
import com.dev.anhnd.android_coroutines_flow.R
import com.dev.anhnd.android_coroutines_flow.databinding.ActivityMainBinding
import com.dev.anhnd.mybase.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId() = R.layout.activity_main

    override fun initBinding() {

    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {

    }

    override fun observerViewModel() {
    }
}
