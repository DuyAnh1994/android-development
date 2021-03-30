package com.dev.anhnd.android_viewpager.profile

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.dev.anhnd.android_viewpager.R
import com.dev.anhnd.android_viewpager.databinding.FragmentProfileBinding
import com.dev.anhnd.android_viewpager.main.MainViewModel
import com.dev.anhnd.mybase.BaseFragment
import com.dev.anhnd.mybase.utils.input.hideKeyBoard

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    private val TAG = ProfileFragment::class.java.simpleName

    //    private val mainViewModel by activityViewModels<MainViewModel>()
    private val mainViewModel by viewModels<MainViewModel>()

    override fun getLayoutId(): Int = R.layout.fragment_profile

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
            R.id.constraint -> {
                hideKeyBoard(binding.edtInput)
                backScreen()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainViewModel
    }
}