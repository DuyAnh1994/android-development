package com.dev.anhnd.android_viewpager.language

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.dev.anhnd.android_viewpager.R
import com.dev.anhnd.android_viewpager.databinding.FragmentLanguageBinding
import com.dev.anhnd.android_viewpager.main.MainActivity
import com.dev.anhnd.android_viewpager.main.MainViewModel
import com.dev.anhnd.mybase.BaseFragment
import com.dev.anhnd.mybase.utils.app.observer

class LanguageFragment : BaseFragment<FragmentLanguageBinding, MainActivity>() {

    private val TAG = LanguageFragment::class.java.simpleName

    //        private val mainViewModel by activityViewModels<MainViewModel>()
    private val mainViewModel by viewModels<MainViewModel>()

    override fun getLayoutId(): Int = R.layout.fragment_language

    override fun setup(savedInstanceState: Bundle?) {

    }

    override fun initBinding() {
        binding.mainViewModel = mainViewModel
    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {
    }

    override fun observerViewModel() {
        observer(mainViewModel.liveText) {
            it?.let {

            }
        }
    }

    override fun onViewClick(viewId: Int) {
        when (viewId) {
            R.id.constraint -> {

            }
            R.id.btnBack -> {
                backScreen()
            }
            R.id.btnNext -> {
                navigateTo(R.id.action_languageFragment_to_profileFragment)
            }
        }
    }
}