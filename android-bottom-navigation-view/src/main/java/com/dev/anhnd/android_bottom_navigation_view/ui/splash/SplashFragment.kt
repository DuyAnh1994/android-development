package com.dev.anhnd.android_bottom_navigation_view.ui.splash

import androidx.navigation.fragment.findNavController
import com.dev.anhnd.android_bottom_navigation_view.R
import com.dev.anhnd.android_bottom_navigation_view.base.BaseCommonFragment
import com.dev.anhnd.android_bottom_navigation_view.databinding.FragmentSplashBinding

class SplashFragment : BaseCommonFragment<FragmentSplashBinding>() {

    override fun getLayoutId() = R.layout.fragment_splash

    override fun initBinding() {
        binding.mainViewModel = mainViewModel
    }

    override fun initView() {
//        GlobalScope.launch {
//            delay(2000)
//            withContext(Dispatchers.Main) {
//                mainViewModel.showMenu()
//                findNavController().navigate(R.id.action_splash_to_home)
//            }
//        }

        binding.root.setOnClickListener {
            mainViewModel.showMenu()
            findNavController().navigate(R.id.action_splashFragment_to_home)
        }
    }
}