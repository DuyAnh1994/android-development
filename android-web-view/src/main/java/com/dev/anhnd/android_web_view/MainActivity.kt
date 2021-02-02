package com.dev.anhnd.android_web_view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.dev.anhnd.android_web_view.databinding.ActivityMainBinding
import com.dev.anhnd.mybase.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId() = R.layout.activity_main

    @SuppressLint("SetJavaScriptEnabled")
    override fun initView(view: View?, savedInstanceState: Bundle?) {
//        binding.webView.apply {
//            settings.javaScriptEnabled = true
//            loadUrl("https://www.24h.com.vn/")
//        }
    }
}
