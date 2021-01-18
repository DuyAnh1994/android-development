package com.dev.anhnd.android_viewpager.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.dev.anhnd.android_viewpager.R
import com.dev.anhnd.android_viewpager.databinding.FragmentProfileBinding
import com.dev.anhnd.android_viewpager.main.MainActivity
import com.dev.anhnd.android_viewpager.main.MainViewModel
import com.dev.anhnd.mybase.BaseFragment
import com.dev.anhnd.mybase.utils.input.hideKeyBoard

class ProfileFragment : BaseFragment<FragmentProfileBinding, MainActivity>() {

    private val TAG = ProfileFragment::class.java.simpleName

    //    private val mainViewModel by activityViewModels<MainViewModel>()
    private val mainViewModel by viewModels<MainViewModel>()

    override fun getLayoutId(): Int = R.layout.fragment_profile

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