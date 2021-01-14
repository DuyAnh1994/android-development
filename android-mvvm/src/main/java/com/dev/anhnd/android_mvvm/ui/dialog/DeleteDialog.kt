package com.dev.anhnd.android_mvvm.ui.dialog

import android.os.Bundle
import android.view.View
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

    override fun setup(savedInstanceState: Bundle?) {
    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {
    }

    override fun observerViewModel() {
    }
}