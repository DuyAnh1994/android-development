package com.dev.anhnd.android_viewpager

import android.os.Bundle
import android.view.View
import com.dev.anhnd.android_viewpager.collection.CollectionFragment
import com.dev.anhnd.android_viewpager.databinding.FragmentRegisterBinding
import com.dev.anhnd.android_viewpager.main.MainActivity
import com.dev.anhnd.mybase.BaseFragment

class RegisterFragment : BaseFragment<FragmentRegisterBinding, MainActivity>() {

    private val TAG = CollectionFragment::class.java.simpleName
    override fun getLayoutId(): Int = R.layout.fragment_register

    override fun setup(savedInstanceState: Bundle?) {

    }

    override fun initBinding() {

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