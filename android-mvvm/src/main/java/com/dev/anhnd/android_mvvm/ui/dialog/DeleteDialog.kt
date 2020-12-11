package com.dev.anhnd.android_mvvm.ui.dialog

import android.view.ViewGroup
import com.dev.anhnd.android_mvvm.R
import com.dev.anhnd.android_mvvm.databinding.DialogDeleteBinding
import com.dev.anhnd.mybase.BaseDialog
import com.dev.anhnd.mybase.DialogInfo

class DeleteDialog : BaseDialog<DialogDeleteBinding>() {

    override fun getDialogInfo(): DialogInfo {
        return DialogInfo(
            resources.getDimension(R.dimen._250sdp).toInt(),
            resources.getDimension(R.dimen._215sdp).toInt(),
            android.R.color.transparent
        )
    }

    override fun getLayoutId(): Int = R.layout.dialog_delete

    override fun getRootViewGroup(): ViewGroup = binding.constraintRoot

    override fun setup() {
    }

    override fun initView() {
    }

    override fun observerViewModel() {
    }
}