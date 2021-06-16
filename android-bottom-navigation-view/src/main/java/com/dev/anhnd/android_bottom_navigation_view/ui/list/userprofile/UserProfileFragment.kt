package com.dev.anhnd.android_bottom_navigation_view.ui.list.userprofile

import com.dev.anhnd.android_bottom_navigation_view.R
import com.dev.anhnd.android_bottom_navigation_view.base.BaseCommonFragment
import com.dev.anhnd.android_bottom_navigation_view.databinding.FragmentUserProfileBinding
import com.dev.anhnd.android_bottom_navigation_view.ui.list.leaderboard.MyAdapter.Companion.USERNAME_KEY

class UserProfileFragment : BaseCommonFragment<FragmentUserProfileBinding>() {

    override fun getLayoutId() = R.layout.fragment_user_profile


    override fun initBinding() {
        binding.mainViewModel = mainViewModel
    }

    override fun initView() {
        val name = arguments?.getString(USERNAME_KEY) ?: "Ali Connors"
        binding.profileUserName.text = name

    }
}
