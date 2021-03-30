package com.dev.anhnd.android_viewpager

import android.os.Bundle
import com.dev.anhnd.android_viewpager.collection.CollectionFragment
import com.dev.anhnd.android_viewpager.databinding.FragmentStudentBinding
import com.dev.anhnd.mybase.BaseFragment

class StudentFragment : BaseFragment<FragmentStudentBinding>() {

    private val TAG = CollectionFragment::class.java.simpleName
    override fun getLayoutId(): Int = R.layout.fragment_student

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