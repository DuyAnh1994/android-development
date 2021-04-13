package com.dev.anhnd.android_navigation_component.like

import com.dev.anhnd.android_navigation_component.R
import com.dev.anhnd.android_navigation_component.databinding.FragmentCameraBinding
import com.dev.anhnd.android_navigation_component.databinding.FragmentDashboardBinding
import com.dev.anhnd.android_navigation_component.databinding.FragmentLikeBinding
import com.dev.anhnd.android_navigation_component.main.BaseMainFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
@WithFragmentBindings
class LikeFragment : BaseMainFragment<FragmentLikeBinding>() {

    private val TAG = LikeFragment::class.java.simpleName


    override fun getLayoutId(): Int = R.layout.fragment_like

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
                navigateTo(R.id.action_likeFragment_to_nav_graph)
            }
        }
    }
}