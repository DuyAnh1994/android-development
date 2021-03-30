package com.dev.anhnd.android_viewpager.setting

import android.os.Bundle
import com.dev.anhnd.android_viewpager.R
import com.dev.anhnd.android_viewpager.databinding.FragmentSettingBinding
import com.dev.anhnd.mybase.BaseFragment

class SettingFragment : BaseFragment<FragmentSettingBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_setting

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
            }
        }
    }
}