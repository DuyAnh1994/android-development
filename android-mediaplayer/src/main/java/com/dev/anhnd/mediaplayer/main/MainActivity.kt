package com.dev.anhnd.mediaplayer.main

import com.dev.anhnd.mediaplayer.R
import com.dev.anhnd.mediaplayer.databinding.ActivityMainBinding
import com.dev.anhnd.mybase.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {

    }

    override fun observerViewModel() {
    }
}
