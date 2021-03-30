package com.dev.anhnd.android_viewpager

import android.os.Bundle
import com.dev.anhnd.android_viewpager.collection.CollectionFragment
import com.dev.anhnd.android_viewpager.databinding.FragmentEmployeeBinding
import com.dev.anhnd.mybase.BaseFragment

class EmployeeFragment : BaseFragment<FragmentEmployeeBinding>() {

    private val TAG = CollectionFragment::class.java.simpleName
    override fun getLayoutId(): Int = R.layout.fragment_employee

    override fun setup() {

    }

    override fun initBinding() {

    }

    override fun initView() {

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