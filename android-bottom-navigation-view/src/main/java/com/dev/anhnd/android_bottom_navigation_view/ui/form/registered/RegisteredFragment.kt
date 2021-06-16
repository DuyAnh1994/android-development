package com.dev.anhnd.android_bottom_navigation_view.ui.form.registered

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.dev.anhnd.android_bottom_navigation_view.R
import com.dev.anhnd.android_bottom_navigation_view.base.BaseCommonFragment
import com.dev.anhnd.android_bottom_navigation_view.databinding.FragmentRegisteredBinding


class RegisteredFragment : BaseCommonFragment<FragmentRegisteredBinding>() {

    override fun getLayoutId() = R.layout.fragment_registered

    override fun initBinding() {
        binding.mainViewModel = mainViewModel
    }

    override fun initView() {
        binding.tvDone.setOnClickListener {
            mainViewModel.hideMenu()
            findNavController().navigate(R.id.action_to_settingFragment)
        }
    }
}
