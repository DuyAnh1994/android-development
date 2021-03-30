package com.dev.anhnd.android_navigation_component.main

import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.dev.anhnd.android_navigation_component.R
import com.dev.anhnd.android_navigation_component.databinding.ActivityMainBinding
import com.dev.anhnd.mybase.BaseActivity
import com.dev.anhnd.mybase.utils.app.observer
import com.dev.anhnd.mybase.utils.bottom_navigation.setupWithNavController

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val TAG = MainActivity::class.java.simpleName
    private var currentNavController: LiveData<NavController>? = null
    var startingPosition: Int = 1
    private var oldPosition: Int = 1

    private val enterAnim = R.anim.slide_exit_right_to_left
    private val exitAnim = R.anim.slide_enter_left_to_right
    private val popEnterAnim = R.anim.slide_pop_exit_left_to_right
    private val popExitAnim = R.anim.slide_pop_enter_right_to_left

    var navGraphIds = listOf<Int>()

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {
        setupBottomNavigationBar()
    }

    /*  private fun getNavOption(newPosition: Int): NavOptions? {
          var navOptions: NavOptions? = null
          val navController = currentNavController?.value!!
          Log.d(TAG, "oldPosition: $oldPosition    newPosition:$newPosition")
          if (oldPosition < newPosition) {
              navOptions = NavOptions.Builder()
                  .setLaunchSingleTop(true)
                  .setEnterAnim(enterAnim)
                  .setExitAnim(exitAnim)
                  .setPopEnterAnim(popEnterAnim)
                  .setPopExitAnim(popExitAnim)
                  .build()
          }
          if (oldPosition > newPosition) {
              navOptions = NavOptions.Builder()
                  .setLaunchSingleTop(true)
                  .setEnterAnim(exitAnim)
                  .setExitAnim(enterAnim)
                  .setPopEnterAnim(popExitAnim)
                  .setPopExitAnim(popEnterAnim)
                  .build()
          }
          oldPosition = newPosition
          return navOptions
      }*/

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    private fun setupBottomNavigationBar() {
        navGraphIds = listOf(R.navigation.nav_home, R.navigation.nav_collection, R.navigation.nav_setting)
        val controller = binding.bottomNav.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_container,
            intent = intent
        )
        observer(controller) {
            it?.let { navController ->
                var newPosition = 0
                val id = navController.graph.id
                when (id) {
                    R.id.nav_home -> {
                        newPosition = 1
                    }
                    R.id.nav_collection -> {
                        newPosition = 2
                    }
                    R.id.nav_setting -> {
                        newPosition = 3
                    }
                }
                setupActionBarWithNavController(navController)
            }
        }
        currentNavController = controller
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
