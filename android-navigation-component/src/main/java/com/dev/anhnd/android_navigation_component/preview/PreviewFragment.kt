package com.dev.anhnd.android_navigation_component.preview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.navGraphViewModels
import com.dev.anhnd.android_navigation_component.R
import com.dev.anhnd.android_navigation_component.databinding.FragmentPreviewBinding
import com.dev.anhnd.android_navigation_component.main.MainActivity
import com.dev.anhnd.android_navigation_component.main.MainViewModel
import com.dev.anhnd.mybase.BaseFragment
import com.dev.anhnd.mybase.utils.app.shareParentFragmentViewModels

class PreviewFragment : BaseFragment<FragmentPreviewBinding, MainActivity>() {

    private val TAG = PreviewFragment::class.java.simpleName

//        private val mainViewModel by activityViewModels<MainViewModel>()
    private val mainViewModel by shareParentFragmentViewModels<MainViewModel>()


    override fun getLayoutId(): Int = R.layout.fragment_preview

    override fun setup(savedInstanceState: Bundle?) {

    }

    override fun initBinding() {
        binding.mainViewModel = mainViewModel
    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {
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