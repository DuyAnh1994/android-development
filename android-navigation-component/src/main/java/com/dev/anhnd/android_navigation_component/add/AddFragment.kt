package com.dev.anhnd.android_navigation_component.add

import com.dev.anhnd.android_navigation_component.R
import com.dev.anhnd.android_navigation_component.databinding.FragmentAddBinding
import com.dev.anhnd.android_navigation_component.databinding.FragmentCameraBinding
import com.dev.anhnd.android_navigation_component.databinding.FragmentDashboardBinding
import com.dev.anhnd.android_navigation_component.main.BaseMainFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
@WithFragmentBindings
class AddFragment : BaseMainFragment<FragmentAddBinding>() {

    private val TAG = AddFragment::class.java.simpleName


    override fun getLayoutId(): Int = R.layout.fragment_add

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
        when (viewId) {
            R.id.btnAbout -> {
                mainViewModel.hideMenu()
                navigateTo(R.id.action_addFragment_to_nav_graph)
            }
        }
    }
}