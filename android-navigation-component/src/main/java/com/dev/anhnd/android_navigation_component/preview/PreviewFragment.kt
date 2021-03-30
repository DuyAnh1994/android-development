package com.dev.anhnd.android_navigation_component.preview

import android.os.Bundle
import com.dev.anhnd.android_navigation_component.R
import com.dev.anhnd.android_navigation_component.databinding.FragmentPreviewBinding
import com.dev.anhnd.android_navigation_component.main.MainViewModel
import com.dev.anhnd.mybase.BaseFragment
import com.dev.anhnd.mybase.utils.app.shareParentFragmentViewModels

class PreviewFragment : BaseFragment<FragmentPreviewBinding>() {

    private val TAG = PreviewFragment::class.java.simpleName

//        private val mainViewModel by activityViewModels<MainViewModel>()
    private val mainViewModel by shareParentFragmentViewModels<MainViewModel>()


    override fun getLayoutId(): Int = R.layout.fragment_preview

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

    override fun onDestroy() {
        super.onDestroy()
        mainViewModel
    }
}