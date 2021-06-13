package com.dev.anhnd.android_multi_viewholder_recyelview.lib

abstract class EnumMapBindAdapter<E : Enum<E>> : DataBindAdapter() {

    private val mapBinder: MutableMap<E, DataBinder<*>> = mutableMapOf()

    override fun getItemCount(): Int {
        var itemCount = 0
        mapBinder.forEach { (_, v) ->
            itemCount += v.getItemCount()
        }
        return itemCount
    }

    override fun getItemViewType(position: Int): Int {
        return getEnumFromPosition(position).ordinal
    }

    override fun <T : DataBinder<*>> getDataBinder(viewType: Int): T {
        return getDataBinder(getEnumFromOrdinal(viewType))
    }

    override fun getPosition(binder: DataBinder<*>, binderPosition: Int): Int {
        var tempBinderPosition = binderPosition
        val targetViewType: E = getEnumFromBinder(binder)
        for (i in 0..itemCount) {
            if (targetViewType == getEnumFromPosition(i)) {
                tempBinderPosition--
                if (tempBinderPosition < 0) {
                    return i
                }
            }
        }
        return itemCount
    }

    override fun getBinderPosition(position: Int): Int {
        val targetViewType: E = getEnumFromPosition(position)
        var binderPosition = -1
        for (i in 0..position) {
            if (targetViewType == getEnumFromPosition(i)) {
                binderPosition++
            }
        }

        if (binderPosition == -1) {
            throw IllegalArgumentException("Invalid Argument")
        }
        return binderPosition
    }

    abstract fun getEnumFromPosition(position: Int): E

    abstract fun getEnumFromOrdinal(ordinal: Int): E

    fun getEnumFromBinder(binder: DataBinder<*>): E {
        mapBinder.entries.forEach {
            if (it.value == binder) {
                return it.key
            }
        }
        throw IllegalArgumentException("Invalid Data Binder")
    }

    fun <T : DataBinder<*>> getDataBinder(e: E): T {
        return mapBinder[e] as T
    }

    fun putBinder(e: E, binder: DataBinder<*>) {
        mapBinder[e] = binder
    }
}
