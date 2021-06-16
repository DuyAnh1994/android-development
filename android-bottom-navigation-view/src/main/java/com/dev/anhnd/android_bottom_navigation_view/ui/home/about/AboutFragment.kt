package com.dev.anhnd.android_bottom_navigation_view.ui.home.about

import android.content.Context
import android.util.Log
import androidx.navigation.fragment.findNavController
import com.dev.anhnd.android_bottom_navigation_view.R
import com.dev.anhnd.android_bottom_navigation_view.base.BaseCommonFragment
import com.dev.anhnd.android_bottom_navigation_view.databinding.FragmentAboutBinding
import com.dev.anhnd.android_bottom_navigation_view.ui.home.title.MessageEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class AboutFragment : BaseCommonFragment<FragmentAboutBinding>() {

    private val TAG = AboutFragment::class.java.simpleName

    override fun onAttach(context: Context) {
        super.onAttach(context)
        EventBus.getDefault().register(this)
    }

    override fun onDetach() {
        super.onDetach()
        EventBus.getDefault().unregister(this)
    }

    override fun getLayoutId() = R.layout.fragment_about

    override fun initBinding() {
        binding.mainViewModel = mainViewModel
    }

    override fun initView() {
        binding.tvAbout.setOnClickListener {
            mainViewModel.hideMenu()
            findNavController().navigate(R.id.action_to_settingFragment)
        }
    }

    override fun onBackPressed() {
        backScreen()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: MessageEvent) {
        Log.d(TAG, "onMessageEvent() called with: event = $event")
    }


}
