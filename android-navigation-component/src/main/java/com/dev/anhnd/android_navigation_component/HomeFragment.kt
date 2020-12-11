package com.dev.anhnd.android_navigation_component

import androidx.navigation.findNavController
import com.dev.anhnd.android_navigation_component.databinding.FragmentHomeBinding
import com.dev.anhnd.mybase.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, MainActivity>() {

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun setup() {

    }

    override fun initView() {
        binding.btSetting.setOnClickListener { v ->
            v.findNavController().navigate(R.id.action_homeFragment_to_settingFragment)
        }
    }

    override fun observerViewModel() {
    }
}