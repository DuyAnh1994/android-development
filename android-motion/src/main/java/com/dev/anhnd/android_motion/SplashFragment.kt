package com.dev.anhnd.android_motion

import com.dev.anhnd.android_coordinator.R
import com.dev.anhnd.android_coordinator.databinding.FragmentHomeBinding
import com.dev.anhnd.android_coordinator.databinding.FragmentSplashBinding
import com.google.android.material.tabs.TabLayoutMediator

class SplashFragment  : BaseMainFragment<FragmentSplashBinding>() {



    override fun getLayoutId() = R.layout.fragment_splash

    override fun initBinding() {

    }

    override fun initView() {

    }

    override fun onViewClick(viewId: Int) {
        when(viewId) {
            R.id.root->{
                navigateTo(R.id.action_splashFragment_to_homeFragment)
            }
        }
    }

    override fun onBackPressed() {

    }
}