package com.dev.anhnd.android_nested_recycleview.ui.nation

import androidx.fragment.app.activityViewModels
import androidx.hilt.Assisted
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.fragment.findNavController
import com.dev.anhnd.android_nested_recycleview.R
import com.dev.anhnd.android_nested_recycleview.databinding.DialogNationBinding
import com.dev.anhnd.android_nested_recycleview.ui.main.MainViewModel
import com.dev.anhnd.mybase.BaseDialog
import com.dev.anhnd.mybase.utils.app.observer
import dagger.hilt.android.AndroidEntryPoint
import org.koin.android.ext.android.bind

@AndroidEntryPoint
class NationDialog : BaseDialog<DialogNationBinding>() {

    private val mainViewModel by activityViewModels<MainViewModel>()

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
}