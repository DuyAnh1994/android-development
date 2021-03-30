package com.dev.anhnd.android_list_demo.main

import android.view.Menu
import com.dev.anhnd.android_list_demo.R
import com.dev.anhnd.android_list_demo.databinding.ActivityMainBinding
import com.dev.anhnd.mybase.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId() = R.layout.activity_main

    override fun initView() {

    }

    override fun observerViewModel() {

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }


}
