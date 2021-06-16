package com.dev.anhnd.android_multi_viewholder_recyelview.lib

abstract class GroupManager<T : GroupData>(groupData: T) {



    abstract fun getGroupData(): T

    abstract fun getItemTypePosition(): Int


}