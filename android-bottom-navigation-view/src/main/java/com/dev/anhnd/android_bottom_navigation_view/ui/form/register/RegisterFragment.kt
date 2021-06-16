package com.dev.anhnd.android_bottom_navigation_view.ui.form.register

import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.dev.anhnd.android_bottom_navigation_view.R
import com.dev.anhnd.android_bottom_navigation_view.base.BaseCommonFragment
import com.dev.anhnd.android_bottom_navigation_view.databinding.FragmentRegisterBinding


class RegisterFragment : BaseCommonFragment<FragmentRegisterBinding>() {

    override fun getLayoutId() = R.layout.fragment_register

    override fun initBinding() {
        binding.mainViewModel = mainViewModel
    }

    override fun initView() {
        binding.root.findViewById<Button>(R.id.signup_btn).setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_registeredFragment)
        }
    }
}
