package com.dev.anhnd.android_bottom_navigation_view.ui

import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.dev.anhnd.android_bottom_navigation_view.R
import com.dev.anhnd.android_bottom_navigation_view.databinding.ActivityMainBinding
import com.dev.anhnd.mybase.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val TAG = MainActivity::class.java.simpleName
    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var navController: NavController

    override fun getLayoutId() = R.layout.activity_main

    override fun initBinding() {
        binding.mainViewModel = mainViewModel
    }

    override fun initView() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostContainer) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNav.setupWithNavController(navController)
    }

    override fun observerViewModel() {
    }

    override fun onViewClick(viewId: Int) {

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}
