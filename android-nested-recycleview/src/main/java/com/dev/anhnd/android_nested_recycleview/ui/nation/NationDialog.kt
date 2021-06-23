package com.dev.anhnd.android_nested_recycleview.ui.nation

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.dev.anhnd.android_nested_recycleview.R
import com.dev.anhnd.android_nested_recycleview.databinding.DialogNationBinding
import com.dev.anhnd.android_nested_recycleview.ui.main.MainViewModel
import com.dev.anhnd.android_nested_recycleview.utils.MessageEvent
import com.dev.anhnd.mybase.BaseDialog
import dagger.hilt.android.AndroidEntryPoint
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@AndroidEntryPoint
class NationDialog : BaseDialog<DialogNationBinding>() {

    private val TAG = NationDialog::class.java.simpleName
    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    override fun getLayoutId() = R.layout.dialog_nation

    override fun getBackgroundDialog() = R.id.backgroundDialog

    override fun isFullScreenWidth() = true

    override fun isFullScreenHeight() = true

    override fun initBinding() {
        binding.mainViewModel = mainViewModel
    }

    override fun initView() {
        mainViewModel.nation.observe(viewLifecycleOwner) {
            it?.let { nation ->
                binding.tvName.text = nation.name
            }
        }
    }

    override fun onViewClick(viewId: Int) {
        when (viewId) {
            R.id.btnBack -> {
                findNavController().popBackStack()
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    fun onMessageEvent(event: MessageEvent) {
        EventBus.getDefault().removeStickyEvent(event)
    }
}