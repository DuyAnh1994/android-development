package com.dev.anhnd.android_mvvm.ui.home

import android.annotation.SuppressLint
import android.view.Gravity
import com.dev.anhnd.android_mvvm.R
import com.dev.anhnd.android_mvvm.databinding.FragmentHomeBinding
import com.dev.anhnd.android_mvvm.ui.dialog.DeleteDialog
import com.dev.anhnd.android_mvvm.ui.dialog.SaveDialog
import com.dev.anhnd.android_mvvm.ui.main.MainActivity
import com.dev.anhnd.mybase.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, MainActivity>() {


    private val dialog by lazy {
        DeleteDialog()
    }

    override fun getLayoutId() = R.layout.fragment_home

    override fun setup() {
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun initView() {
        binding.constraintRoot.setOnTouchListener { v, e ->
            val newLocation = intArrayOf(e.x.toInt(), e.y.toInt())
            dialog.apply {
//                configLocation(newLocation, Gravity.CENTER or Gravity.BOTTOM)
                showMyDialog(childFragmentManager, SaveDialog::class.java.simpleName)
            }
            return@setOnTouchListener false
        }
    }

    override fun observerViewModel() {
    }
}