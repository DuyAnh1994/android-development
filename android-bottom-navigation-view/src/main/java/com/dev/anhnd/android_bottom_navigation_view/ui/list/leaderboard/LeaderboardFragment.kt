package com.dev.anhnd.android_bottom_navigation_view.ui.list.leaderboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dev.anhnd.android_bottom_navigation_view.R
import com.dev.anhnd.android_bottom_navigation_view.base.BaseCommonFragment
import com.dev.anhnd.android_bottom_navigation_view.databinding.FragmentLeaderboardBinding

/**
 * Shows a static leaderboard with multiple users.
 */
class LeaderboardFragment : BaseCommonFragment<FragmentLeaderboardBinding>() {

    private val viewAdapter = MyAdapter(Array(10) { "Person ${it + 1}" })


    override fun getLayoutId() = R.layout.fragment_leaderboard

    override fun initBinding() {
        binding.mainViewModel = mainViewModel
    }

    override fun initView() {
        binding.leaderboardList.run {
            setHasFixedSize(true)
            adapter = viewAdapter
        }
    }

}
