package com.dev.anhnd.android_navigation_component.main

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.activityViewModels
import com.dev.anhnd.mybase.BaseFragment

abstract class BaseMainFragment<DB : ViewDataBinding> : BaseFragment<DB>() {

    val mainViewModel by activityViewModels<MainViewModel>()

    val activityOwner by lazy {
        requireActivity() as MainActivity
    }
}
