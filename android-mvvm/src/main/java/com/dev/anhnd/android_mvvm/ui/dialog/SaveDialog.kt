package com.dev.anhnd.android_mvvm.ui.dialog

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.dev.anhnd.android_mvvm.R
import com.dev.anhnd.android_mvvm.databinding.DialogSaveBinding
import com.dev.anhnd.mybase.BaseDialog
import com.dev.anhnd.mybase.DialogInfo
import com.dev.anhnd.mybase.utils.input.hideKeyBoard
import com.dev.anhnd.mybase.utils.input.showKeyBoard

class SaveDialog : BaseDialog<DialogSaveBinding>() {

    private val TAG = SaveDialog::class.java.simpleName

    private var isShowKeyboard = false

    override fun getDialogInfo(): DialogInfo {
        return DialogInfo(
            resources.getDimension(R.dimen._250sdp).toInt(),
            resources.getDimension(R.dimen._215sdp).toInt(),
            android.R.color.transparent
        )
    }

    override fun getLayoutId(): Int = R.layout.dialog_save

    override fun getRootViewGroup(): ViewGroup = binding.constraintRoot

    override fun setup(savedInstanceState: Bundle?) {
    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {
        binding.bindingListener = this
        requestFocus()
        binding.etInput.setOnFocusChangeListener { _, hasFocus ->
            Log.d(TAG, "hasFocus: $hasFocus")
            if (hasFocus) {
                isShowKeyboard = hasFocus
            }
        }
    }

    override fun observerViewModel() {
    }

    fun onClickCancel(v: View) {
        binding.etInput.apply {
            clearFocus()
            isShowKeyboard = false
        }
        hideKeyBoard(v)
    }

    override fun onResume() {
        super.onResume()
        if (isShowKeyboard) {
            requestFocus()
        }
    }

    private fun requestFocus() {
        val runnable = Runnable {
            binding.etInput.apply {
                requestFocus()
                isFocusable = true
                isFocusableInTouchMode = true
                showKeyBoard(this)
            }
            isShowKeyboard = true
        }
        Handler(Looper.getMainLooper()).postDelayed(runnable, 300)
    }
}