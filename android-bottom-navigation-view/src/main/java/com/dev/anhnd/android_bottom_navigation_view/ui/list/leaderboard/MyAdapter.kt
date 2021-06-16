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

class MyAdapter(private val myDataset: Array<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    companion object {
        const val USERNAME_KEY = "userName"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_view_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item.findViewById<TextView>(R.id.user_name_text).text = myDataset[position]
        holder.item.findViewById<ImageView>(R.id.user_avatar_image).setImageResource(listOfAvatars[position % listOfAvatars.size])
        holder.item.setOnClickListener {
            val bundle = bundleOf(USERNAME_KEY to myDataset[position])
            holder.item.findNavController().navigate(R.id.action_leaderboardFragment_to_userProfileFragment, bundle)
        }
    }

    override fun getItemCount() = myDataset.size

    class ViewHolder(val item: View) : RecyclerView.ViewHolder(item)
}

private val listOfAvatars = listOf(
    R.drawable.avatar_1_raster,
    R.drawable.avatar_2_raster,
    R.drawable.avatar_3_raster,
    R.drawable.avatar_4_raster,
    R.drawable.avatar_5_raster,
    R.drawable.avatar_6_raster
)
