package com.dev.anhnd.android_nested_recycleview.model

import com.dev.anhnd.android_nested_recycleview.model.Nation

data class Continents(val name: String = "",
                      val nations: MutableList<Nation> = mutableListOf()
)