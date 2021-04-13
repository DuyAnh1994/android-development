package com.dev.anhnd.android_navigation_component.main

import com.dev.anhnd.android_navigation_component.R
import com.dev.anhnd.android_navigation_component.databinding.FragmentMainBinding
import com.dev.anhnd.mybase.utils.app.observer
import com.dev.anhnd.mybase.utils.bottom_navigation.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
@WithFragmentBindings
class MainFragment : BaseMainFragment<FragmentMainBinding>() {

    private val TAG = MainFragment::class.java.simpleName

    override fun getLayoutId(): Int = R.layout.fragment_main

    override fun setup() {

    }

    override fun initBinding() {
        binding.mainViewModel = mainViewModel
    }

    override fun initView() {
        setupBottomNavigationBar()
    }

    override fun observerViewModel() {

    }

    override fun onViewClick(viewId: Int) {

    }

    private fun setupBottomNavigationBar() {
        val navGraphIds = listOf(
            R.navigation.nav_home,
            R.navigation.nav_search,
            R.navigation.nav_add,
            R.navigation.nav_like,
            R.navigation.nav_setting
        )
        val controller = binding.bottomNav.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = childFragmentManager,
            containerId = R.id.nav_host_main,
            intent = activityOwner.intent
        )
        observer(controller) {
        }
        activityOwner.currentNavController = controller
    }
}