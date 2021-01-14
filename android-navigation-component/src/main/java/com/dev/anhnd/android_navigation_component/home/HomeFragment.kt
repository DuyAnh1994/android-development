package com.dev.anhnd.android_navigation_component.home

import android.os.Bundle
import android.view.View
import com.dev.anhnd.android_navigation_component.R
import com.dev.anhnd.android_navigation_component.databinding.FragmentHomeBinding
import com.dev.anhnd.android_navigation_component.main.MainActivity
import com.dev.anhnd.mybase.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, MainActivity>() {

    private val TAG = HomeFragment::class.java.simpleName

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun setup(savedInstanceState: Bundle?) {

    }

    override fun initBinding() {

    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {

    }

    override fun observerViewModel() {

    }

    override fun onViewClick(viewId: Int) {
        when (viewId) {
            R.id.constraint -> {
                navigateTo(R.id.action_homeFragment_to_aboutFragment)
            }
        }
    }
}