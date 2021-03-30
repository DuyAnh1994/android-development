package com.dev.anhnd.android_navigation_component.language

import android.os.Bundle
import com.dev.anhnd.android_navigation_component.R
import com.dev.anhnd.android_navigation_component.databinding.FragmentLanguageBinding
import com.dev.anhnd.android_navigation_component.main.MainViewModel
import com.dev.anhnd.mybase.BaseFragment
import com.dev.anhnd.mybase.utils.app.shareParentFragmentViewModels

class LanguageFragment : BaseFragment<FragmentLanguageBinding>() {

    private val TAG = LanguageFragment::class.java.simpleName
//    private val mainViewModel by activityViewModels<MainViewModel>()
    private val mainViewModel by shareParentFragmentViewModels<MainViewModel>()

    override fun getLayoutId(): Int = R.layout.fragment_language

    override fun setup() {

    }

    override fun initBinding() {
        binding.mainViewModel = mainViewModel
    }

    override fun initView() {
    }

    override fun observerViewModel() {

    }

    override fun onViewClick(viewId: Int) {
        when (viewId) {

        }
    }
}