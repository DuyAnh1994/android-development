package com.dev.anhnd.android_motion

import android.util.Log
import com.dev.anhnd.android_coordinator.R
import com.dev.anhnd.android_coordinator.databinding.FragmentSecondBinding
import com.dev.anhnd.android_coordinator.databinding.FragmentThirdBinding
import com.dev.anhnd.mybase.utils.toast.toast

class ThirdFragment : BaseMainFragment<FragmentThirdBinding>() {

    private val TAG = ThirdFragment::class.java.simpleName
    private val adapter by lazy {
        FirstAdapter().apply {
            listener = object  : FirstItemListener {
                override fun onClickItem(position: Int) {
                    navigateTo(R.id.action_thirdFragment_to_fourFragment)
                }
            }
        }
    }

    override fun getLayoutId() = R.layout.fragment_third


    override fun initBinding() {
        binding.adapter = adapter
    }

    override fun initView() {
        adapter.submitList(DataUtils.firsts)

    }

    override fun onBackPressed() {
        Log.d(TAG, "onBackPressed: ")
        popBackStack(R.id.homeFragment)
        backScreen()
    }
}