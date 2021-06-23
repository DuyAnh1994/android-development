package com.dev.anhnd.android_nested_recycleview.ui.nation

import android.util.Log
import com.dev.anhnd.android_nested_recycleview.R
import com.dev.anhnd.android_nested_recycleview.databinding.FragmentNationBinding
import com.dev.anhnd.android_nested_recycleview.ui.main.BaseMainFragment
import com.dev.anhnd.android_nested_recycleview.utils.MessageEvent
import dagger.hilt.android.AndroidEntryPoint
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@AndroidEntryPoint
class NationFragment : BaseMainFragment<FragmentNationBinding>() {

    private val TAG = NationFragment::class.java.simpleName

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    override fun getLayoutId() = R.layout.fragment_nation

    override fun initBinding() {

    }

    override fun initView() {
        binding.mainViewModel = mainViewModel
    }

    override fun observerViewModel() {

    }

    override fun onViewClick(viewId: Int) {
        when (viewId) {
            R.id.btnBack -> {
                onBackPressed()
            }
        }
    }

    override fun onBackPressed() {
        backScreen()
//        screenTransitionManageImp.backScreen()
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    fun onMessageEvent(event: MessageEvent) {
        event.data?.let {
            binding.mcvFlag.setImageResource(it.flag)
        }
        EventBus.getDefault().removeStickyEvent(event)
    }
}