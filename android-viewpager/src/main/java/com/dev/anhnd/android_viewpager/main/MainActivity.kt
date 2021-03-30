package com.dev.anhnd.android_viewpager.main

import com.dev.anhnd.android_viewpager.R
import com.dev.anhnd.android_viewpager.databinding.ActivityMainBinding
import com.dev.anhnd.mybase.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val TAG = MainActivity::class.java.simpleName

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {
    }


    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
