package com.dev.anhnd.android_bottom_navigation_view.ui.setting

import androidx.navigation.fragment.findNavController
import com.dev.anhnd.android_bottom_navigation_view.R
import com.dev.anhnd.android_bottom_navigation_view.base.BaseCommonFragment
import com.dev.anhnd.android_bottom_navigation_view.databinding.FragmentSettingBinding

class SettingFragment : BaseCommonFragment<FragmentSettingBinding>() {

    override fun getLayoutId() = R.layout.fragment_setting


    override fun initBinding() {
        binding.mainViewModel = mainViewModel
    }

    override fun initView() {
        binding.ivBack.setOnClickListener {
            mainViewModel.showMenu()
            findNavController().popBackStack()
        }
    }
}