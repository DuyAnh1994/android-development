package com.dev.anhnd.android_web_view

import android.annotation.SuppressLint
import android.webkit.WebViewClient
import com.dev.anhnd.android_web_view.databinding.ActivityMainBinding
import com.dev.anhnd.mybase.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId() = R.layout.activity_main

    @SuppressLint("SetJavaScriptEnabled")
    override fun initView() {
        binding.webView.apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
            loadUrl("https://www.themoviedb.org/")
            setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
                val deltaY = scrollY - oldScrollY
                binding.header.translationY -= deltaY
                binding.footer.translationY += deltaY
            }
        }
    }
}
