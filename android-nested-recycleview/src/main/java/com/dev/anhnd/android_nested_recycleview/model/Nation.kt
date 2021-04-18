package com.dev.anhnd.android_nested_recycleview.model

import android.os.Parcelable
import com.dev.anhnd.android_nested_recycleview.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Nation(val flag: Int = R.drawable.ic_nation_vietnam,
                  val name: String = ""
) : Parcelable