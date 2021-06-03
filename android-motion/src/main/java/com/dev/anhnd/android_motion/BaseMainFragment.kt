package com.dev.anhnd.android_motion

import androidx.databinding.ViewDataBinding
import com.dev.anhnd.mybase.BaseFragment

abstract class BaseMainFragment<DB : ViewDataBinding> : BaseFragment<DB>() {

    val activityOwner by lazy {
        requireActivity() as MainActivity
    }


}