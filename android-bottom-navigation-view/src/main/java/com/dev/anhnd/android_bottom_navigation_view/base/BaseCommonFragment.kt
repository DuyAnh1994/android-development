package com.dev.anhnd.android_bottom_navigation_view.base

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.activityViewModels
import com.dev.anhnd.android_bottom_navigation_view.ui.MainViewModel
import com.dev.anhnd.mybase.BaseFragment

abstract class BaseCommonFragment<DB : ViewDataBinding> : BaseFragment<DB>() {

    protected val mainViewModel by activityViewModels<MainViewModel>()

}

