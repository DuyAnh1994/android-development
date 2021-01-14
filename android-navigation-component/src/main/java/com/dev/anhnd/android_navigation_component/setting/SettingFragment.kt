package com.dev.anhnd.android_navigation_component.setting

import android.os.Bundle
import android.view.View
import com.dev.anhnd.android_navigation_component.R
import com.dev.anhnd.android_navigation_component.databinding.FragmentSettingBinding
import com.dev.anhnd.android_navigation_component.main.MainActivity
import com.dev.anhnd.mybase.BaseFragment

class SettingFragment : BaseFragment<FragmentSettingBinding, MainActivity>() {

    override fun getLayoutId(): Int = R.layout.fragment_setting

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
                navigateTo(R.id.action_settingFragment_to_languageFragment)
            }
        }
    }
}