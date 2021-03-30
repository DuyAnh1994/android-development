package com.dev.anhnd.mybase.utils.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.anhnd.mybase.BR
import com.dev.anhnd.mybase.utils.adapter.BaseMultiHolderAdapter.BaseModelType
import com.dev.anhnd.mybase.utils.adapter.touch.*
import com.dev.anhnd.mybase.utils.adapter.viewholder.BaseDiffUtilCallback
import com.dev.anhnd.mybase.utils.adapter.viewholder.BaseViewHolder
import com.dev.anhnd.mybase.utils.adapter.viewholder.ListItemListener
import com.dev.anhnd.mybase.utils.app.postSelf
import java.util.*

abstract class BaseMultiHolderAdapter<T : BaseModelType>(
    @LayoutRes private val resLayout: List<Int>
) : RecyclerView.Adapter<BaseViewHolder>(),
    DiffUtilListener<T>,
    SelectItemTouchListener<T>,
    DragItemTouchListener {

    companion object {
        const val VIEW_TYPE_DEFAULT = 0
    }

    private lateinit var inflater: LayoutInflater
    private var itemTouchHelperExtension: ItemTouchHelperExtension? = null
    private var annotationDrag: ItemTouchDrag? = null
    private var annotationSwipe: ItemTouchSwipe? = null
    private var annotationSelect: ItemTouchSelect? = null

    /**
     * List items
     */
    var data: MutableList<T>? = null
        private set

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

    override fun getItemCount() = data?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        if (!::inflater.isInitialized) {
            inflater = LayoutInflater.from(parent.context)
        }
        val binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, resLayout[viewType], parent, false)
        return BaseViewHolder(binding, annotationSwipe)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.binding.apply {
            // item of list
            setVariable(BR.item, data?.get(holder.adapterPosition))
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

    override fun getItemViewType(position: Int) = data?.get(position)?.viewType ?: VIEW_TYPE_DEFAULT

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
                    if (!data.isNullOrEmpty()) {
                        val lastCompleteShowPosition = layout.findLastVisibleItemPosition()
                        if (lastCompleteShowPosition == itemCount - 1 && dy > 0) {
                            onLoadMore.invoke()
                        }
                    }
                }
            }
        })
    }

    override fun submitList(newData: MutableList<T>?) {
        val callback = BaseDiffUtilCallback(data, newData)
        val diffResult = DiffUtil.calculateDiff(callback)
        this.data = newData
        diffResult.dispatchUpdatesTo(this)
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
            data?.forEach {
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
        data?.let { list ->
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

    /**
     * Must extend this class if use multi type view holder for list
     */
    abstract class BaseModelType(open val viewType: Int = VIEW_TYPE_DEFAULT)
}
