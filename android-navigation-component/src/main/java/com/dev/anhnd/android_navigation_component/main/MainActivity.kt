package com.dev.anhnd.android_navigation_component.main

import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.dev.anhnd.android_navigation_component.R
import com.dev.anhnd.android_navigation_component.camera.CameraFragment
import com.dev.anhnd.android_navigation_component.dashboard.DashboardFragment
import com.dev.anhnd.android_navigation_component.databinding.ActivityMainBinding
import com.dev.anhnd.mybase.BaseActivity
import com.dev.anhnd.mybase.utils.app.observer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
        private const val CAMERA_POSITION = 0
        private const val MAIN_POSITION = 1
        private const val DASHBOARD_POSITION = 2
    }

    private val mainViewModel by viewModels<MainViewModel>()
    private val cameraFragment = CameraFragment()
    private val mainFragment = MainFragment()
    private val dashboardFragment = DashboardFragment()

    var currentNavController: LiveData<NavController>? = null

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initBinding() {
        binding.mainViewModel = mainViewModel
    }

    override fun initView() {
        val mainPagerAdapter by lazy {
            MainPagerAdapter(supportFragmentManager, lifecycle).apply {
                addFragment(cameraFragment, "Camera", CAMERA_POSITION)
                addFragment(mainFragment, "Main", MAIN_POSITION)
                addFragment(dashboardFragment, "Dashboard", DASHBOARD_POSITION)
            }
        }
//        binding.viewpager.apply {
//            offscreenPageLimit = mainPagerAdapter.itemCount
//            adapter = mainPagerAdapter
//            post {
//                currentItem = MAIN_POSITION
//            }
//        }

        binding.bottomNav.apply {
            setupWithNavController(getMainNavController())
            setOnNavigationItemSelectedListener {
                if (getMainNavController().graph.findNode(it.itemId) != null) {
                    getMainNavController().navigate(it.itemId)
                    val size = getMainNavController().graph
                    Log.d(TAG, "initView: ")
                    return@setOnNavigationItemSelectedListener true
                }
                false
            }
        }
    }

    override fun observerViewModel() {
        observer(mainViewModel.getLiveMenu()) {
            it?.let { isShowMenu ->
//                binding.viewpager.isUserInputEnabled = isShowMenu
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }


    private fun getMainNavController(): NavController {
        return findNavController(R.id.nav_host_main)
    }
}
