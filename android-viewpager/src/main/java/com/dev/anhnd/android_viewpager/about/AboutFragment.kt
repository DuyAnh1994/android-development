package com.dev.anhnd.android_viewpager.about

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.dev.anhnd.android_viewpager.R
import com.dev.anhnd.android_viewpager.databinding.FragmentAboutBinding
import com.dev.anhnd.android_viewpager.main.MainActivity
import com.dev.anhnd.android_viewpager.main.MainViewModel
import com.dev.anhnd.mybase.BaseFragment

class AboutFragment : BaseFragment<FragmentAboutBinding, MainActivity>() {

    private val TAG = AboutFragment::class.java.simpleName
    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun getLayoutId(): Int = R.layout.fragment_about

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
        }
    }
}