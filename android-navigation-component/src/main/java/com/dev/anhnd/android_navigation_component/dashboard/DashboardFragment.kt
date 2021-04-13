package com.dev.anhnd.android_navigation_component.dashboard

import com.dev.anhnd.android_navigation_component.R
import com.dev.anhnd.android_navigation_component.databinding.FragmentDashboardBinding
import com.dev.anhnd.android_navigation_component.main.BaseMainFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
@WithFragmentBindings
class DashboardFragment : BaseMainFragment<FragmentDashboardBinding>() {

    private val TAG = DashboardFragment::class.java.simpleName


    override fun getLayoutId(): Int = R.layout.fragment_dashboard

    override fun setup() {

    }

    override fun initBinding() {
        binding.mainViewModel = mainViewModel
    }

    override fun initView() {


    }

    override fun observerViewModel() {

    }

    override fun onViewClick(viewId: Int) {

    }
}