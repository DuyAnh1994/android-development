package com.dev.anhnd.android_motion

import android.util.Log
import com.dev.anhnd.android_coordinator.R
import com.dev.anhnd.android_coordinator.databinding.FragmentSecondBinding
import com.dev.anhnd.mybase.utils.toast.toast

class SecondFragment : BaseMainFragment<FragmentSecondBinding>() {

    private val TAG = SecondFragment::class.java.simpleName
    private val adapter by lazy {
        SecondAdapter().apply {
            listener = object : SecondItemListener {
                override fun onClickItem(position: Int) {
                    toast(position.toString())
                }
            }
        }
    }

    override fun getLayoutId() = R.layout.fragment_second

    override fun initBinding() {
        binding.adapter = adapter
    }

    override fun initView() {
        adapter.submitList(DataUtils.second)

    }

    override fun onBackPressed() {
        Log.d(TAG, "onBackPressed: ")
        backScreen()
    }
}