package com.dev.anhnd.android_mvvm.ui.dialog

import android.os.Bundle
import android.view.View
import com.dev.anhnd.android_mvvm.R
import com.dev.anhnd.android_mvvm.databinding.DialogDeleteBinding
import com.dev.anhnd.mybase.BaseDialog

class DeleteDialog : BaseDialog<DialogDeleteBinding>() {

    override fun getLayoutId() = R.layout.dialog_delete

    override fun getRootViewGroup() = binding.constraintRoot

    override fun getBackgroundDialog() = R.id.backgroundDialog

    override fun setup(savedInstanceState: Bundle?) {
    }

    override fun initBinding() {

    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {
    }

    override fun observerViewModel() {
    }
}