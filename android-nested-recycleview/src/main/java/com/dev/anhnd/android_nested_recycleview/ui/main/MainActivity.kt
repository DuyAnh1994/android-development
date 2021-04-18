package com.dev.anhnd.android_nested_recycleview.ui.main

import com.dev.anhnd.android_nested_recycleview.R
import com.dev.anhnd.android_nested_recycleview.databinding.ActivityMainBinding
import com.dev.anhnd.android_nested_recycleview.ui.home.HomeFragment
import com.dev.anhnd.mybase.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun getLayoutId() = R.layout.activity_main

    override fun getContainer() = R.id.container

    override fun initBinding() {

    }

    override fun initView() {
        /*transitionTo(
            HomeFragment(),
            R.anim.slide_enter_left_to_right,
            R.anim.slide_exit_right_to_left,
            R.anim.slide_pop_enter_right_to_left,
            R.anim.slide_pop_exit_left_to_right,
        )*/


    }

    override fun observerViewModel() {

    }

    override fun onViewClick(viewId: Int) {

    }
}
