package com.dev.anhnd.android_bottom_navigation_view.ui.home.title

import com.dev.anhnd.android_bottom_navigation_view.R
import com.dev.anhnd.android_bottom_navigation_view.base.BaseCommonFragment
import com.dev.anhnd.android_bottom_navigation_view.databinding.FragmentTitleBinding
import org.greenrobot.eventbus.EventBus

class TitleFragment : BaseCommonFragment<FragmentTitleBinding>() {

    override fun getLayoutId() = R.layout.fragment_title

    override fun initBinding() {
        binding.mainViewModel = mainViewModel
    }

    override fun initView() {
        binding.btnAbout.setOnClickListener {
            val msg = MessageEvent().apply {
                data = "Content"
            }
            EventBus.getDefault().post(msg)
            navigateTo(R.id.action_titleFragment_to_aboutFragment)
        }
    }

    override fun onBackPressed() {
        popBackStack(R.id.splashFragment)
    }
}

class MessageEvent {
    var data: Any? = null
}