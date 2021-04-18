package com.dev.anhnd.android_nested_recycleview.ui.nation

import com.dev.anhnd.android_nested_recycleview.R
import com.dev.anhnd.android_nested_recycleview.databinding.FragmentNationBinding
import com.dev.anhnd.android_nested_recycleview.ui.main.BaseMainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NationFragment : BaseMainFragment<FragmentNationBinding>() {


    override fun getLayoutId() = R.layout.fragment_nation


    override fun initBinding() {

    }

    override fun initView() {
        binding.mainViewModel = mainViewModel
    }

    override fun observerViewModel() {

    }

    override fun onViewClick(viewId: Int) {
        when (viewId) {
            R.id.btnBack -> {
                onBackPressed()
            }
        }
    }

    override fun onBackPressed() {
        backScreen()
//        screenTransitionManageImp.backScreen()
    }
}