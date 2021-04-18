package com.dev.anhnd.android_nested_recycleview.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Continents(val name: String = "",
                      val nations: MutableList<Nation> = mutableListOf()
) : Parcelable