package com.dev.anhnd.mybase.utils.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dev.anhnd.mybase.BR
import com.dev.anhnd.mybase.utils.adapter.touch.*
import com.dev.anhnd.mybase.utils.adapter.viewholder.BaseDiffUtilItemCallback
import com.dev.anhnd.mybase.utils.adapter.viewholder.BaseViewHolder
import com.dev.anhnd.mybase.utils.adapter.viewholder.ListItemListener
import com.dev.anhnd.mybase.utils.app.postSelf
import java.util.*

@Deprecated(message = "Not support this class, migrate to BaseAdapter or BaseMultiHolderAdapter")
abstract class BaseListAdapter<T : Any>(
    @LayoutRes private val resLayout: Int,
    diffUtil: BaseDiffUtilItemCallback<T>
) : ListAdapter<T, BaseViewHolder>(diffUtil),
    SelectItemTouchListener<T>,
    DragItemTouchListener {

    private lateinit var inflater: LayoutInflater
    private var itemTouchHelperExtension: ItemTouchHelperExtension? = null
    private var annotationDrag: ItemTouchDrag? = null
    private var annotationSwipe: ItemTouchSwipe? = null
    private var annotationSelect: ItemTouchSelect? = null

    /**
     * Listener action in item of list
     */
    var listener: ListItemListener? = null

    /**
     * List items selected
     */

    var liveSelect = MutableLiveData(Stack<T>())

    /**
     * Listener load more
     */
    var onLoadMore: () -> Unit = {}

    init {
        val annotations = this::class.java.declaredAnnotations
        for (annotation in annotations) {
            when (annotation) {
                is ItemTouchDrag -> {
                    annotationDrag = annotation
                }
                is ItemTouchSwipe -> {
                    annotationSwipe = annotation
                }
                is ItemTouchSelect -> {
                    annotationSelect = annotation
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        if (!::inflater.isInitialized) {
            inflater = LayoutInflater.from(parent.context)
        }
        val binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, resLayout, parent, false)
        return BaseViewHolder(binding, annotationSwipe)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.binding.apply {
            // item of list
            setVariable(BR.item, getItem(holder.adapterPosition))
            // callback of view holder
            setVariable(BR.itemListener, listener)
            // position of item in list
            setVariable(BR.itemPosition, holder.adapterPosition)
            // item selected in list
            setVariable(BR.liveSelect, liveSelect)
            // context in list
            val context = root.context as LifecycleOwner
            lifecycleOwner = context
            executePendingBindings()
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        // drag drop item
        annotationDrag?.let {
            val callback = DragVerticalTouchHelper(this)
            ItemTouchHelper(callback).attachToRecyclerView(recyclerView)
        }
        // swipe item
        annotationSwipe?.let {
            val callback = SwipeTouchHelper(it.mode, it.isSpring)
            itemTouchHelperExtension = ItemTouchHelperExtension(callback).apply {
                attachToRecyclerView(recyclerView)
            }
        }
        // Load more
        val layoutManager = recyclerView.layoutManager
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                (layoutManager as LinearLayoutManager).let { layout ->
                    if (!currentList.toMutableList().isNullOrEmpty()) {
                        val lastCompleteShowPosition = layout.findLastVisibleItemPosition()
                        if (lastCompleteShowPosition == itemCount - 1 && dy > 0) {
                            onLoadMore.invoke()
                        }
                    }
                }
            }
        })
    }

    override fun select(t: T) {
        annotationSelect?.let {
            val select = liveSelect.value ?: Stack()
            if (select.search(t) != -1) {
                select.remove(t)
            } else {
                if (it.mode == SelectedMode.SINGLE_SELECT) {
                    select.clear()
                }
                select.add(t)
            }
            liveSelect.postSelf()
        }
    }

    override fun unSelect(t: T) {
        annotationSelect?.let {
            val select = liveSelect.value ?: Stack()
            if (select.search(t) != -1) {
                select.remove(t)
                liveSelect.postSelf()
            }
        }
    }

    override fun selectAll() {
        annotationSelect?.let {
            val select = liveSelect.value ?: Stack()
            currentList.toMutableList().forEach {
                select.add(it)
            }
            liveSelect.postSelf()
        }
    }

    override fun clearAll() {
        annotationSelect?.let {
            val select = liveSelect.value ?: Stack()
            select.clear()
            liveSelect.postSelf()
        }
    }

    override fun onMove(from: Int, to: Int) {
        currentList.toMutableList().let { list ->
            if (from < to) {
                for (i in from until to) {
                    Collections.swap(list, i, i + 1)
                    notifyItemChanged(i, list[i])
                    notifyItemChanged(i + 1, list[i])
                }
            } else {
                for (i in from downTo to + 1) {
                    Collections.swap(list, i, i - 1)
                    notifyItemChanged(i, list[i])
                    notifyItemChanged(i - 1, list[i])
                }
            }
            notifyItemMoved(from, to)
        }
    }
}
