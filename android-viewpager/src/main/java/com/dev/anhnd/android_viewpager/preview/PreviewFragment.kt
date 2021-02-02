package com.dev.anhnd.android_viewpager.preview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.dev.anhnd.android_viewpager.R
import com.dev.anhnd.android_viewpager.databinding.FragmentPreviewBinding
import com.dev.anhnd.android_viewpager.main.MainActivity
import com.dev.anhnd.android_viewpager.main.MainViewModel
import com.dev.anhnd.mybase.BaseFragment

class PreviewFragment : BaseFragment<FragmentPreviewBinding>() {

    private val TAG = PreviewFragment::class.java.simpleName

    //        private val mainViewModel by activityViewModels<MainViewModel>()
    private val mainViewModel by viewModels<MainViewModel>()


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
            R.id.constraint -> {

            }
            R.id.btnBack -> {
                backScreen()
            }
            R.id.btnNext -> {
                navigateTo(R.id.action_previewFragment_to_leaderBoardFragment)
            }
        }
    }
}