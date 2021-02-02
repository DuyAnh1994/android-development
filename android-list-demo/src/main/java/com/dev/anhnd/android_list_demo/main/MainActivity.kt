package com.dev.anhnd.android_list_demo.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.dev.anhnd.android_list_demo.R
import com.dev.anhnd.android_list_demo.databinding.ActivityMainBinding
import com.dev.anhnd.mybase.BaseActivity
import com.dev.anhnd.mybase.utils.log.logd
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId() = R.layout.activity_main

    override fun initView(view: View?, savedInstanceState: Bundle?) {

    }


    override fun observerViewModel() {

    }
}
