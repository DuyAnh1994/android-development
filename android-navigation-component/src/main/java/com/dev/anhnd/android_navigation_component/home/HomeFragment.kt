package com.dev.anhnd.android_navigation_component.home

import android.os.Bundle
import com.dev.anhnd.android_navigation_component.R
import com.dev.anhnd.android_navigation_component.databinding.FragmentHomeBinding
import com.dev.anhnd.mybase.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val TAG = HomeFragment::class.java.simpleName

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun setup() {

    }

    override fun initBinding() {

    }

    override fun initView() {

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