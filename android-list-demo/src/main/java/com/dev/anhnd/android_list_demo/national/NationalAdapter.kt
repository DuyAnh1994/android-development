package com.dev.anhnd.android_list_demo.national

import com.dev.anhnd.android_list_demo.R
import com.dev.anhnd.mybase.utils.adapter.BaseAdapter
import com.dev.anhnd.mybase.utils.adapter.touch.*

@ItemTouchDrag
@ItemTouchSwipe(mode = SwipeMode.RIGHT_TO_LEFT, isSpring = false)
@ItemTouchSelect(mode = SelectedMode.MULTIPLE_SELECT)
class NationalAdapter : BaseAdapter<National>(R.layout.item_national)
