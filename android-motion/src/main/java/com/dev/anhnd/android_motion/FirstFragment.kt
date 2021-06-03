package com.dev.anhnd.android_motion

import android.util.Log
import com.dev.anhnd.android_coordinator.R
import com.dev.anhnd.android_coordinator.databinding.FragmentFirstBinding

class FirstFragment : BaseMainFragment<FragmentFirstBinding>() {

    private val TAG = FirstFragment::class.java.simpleName
    private val adapter by lazy {
        FirstAdapter().apply {
            listener = object  : FirstItemListener {
                override fun onClickItem(position: Int) {
                    navigateTo(R.id.action_homeFragment_to_fourFragment)
                }
            }
        }
    }

    override fun getLayoutId() = R.layout.fragment_first

    override fun initBinding() {
        binding.adapter = adapter
    }

    override fun initView() {
        adapter.submitList(DataUtils.firsts)
    }

    override fun onBackPressed() {
        Log.d(TAG, "onBackPressed: ")
        backScreen()
    }


}