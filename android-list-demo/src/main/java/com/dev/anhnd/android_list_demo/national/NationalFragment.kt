package com.dev.anhnd.android_list_demo.national

import android.os.Bundle
import android.view.MenuItem
import com.dev.anhnd.android_list_demo.R
import com.dev.anhnd.android_list_demo.databinding.FragmentNationalBinding
import com.dev.anhnd.android_list_demo.main.MainActivity
import com.dev.anhnd.mybase.BaseFragment
import com.dev.anhnd.mybase.utils.app.observer
import com.dev.anhnd.mybase.utils.log.logd
import com.dev.anhnd.mybase.utils.toast.toast
import org.koin.androidx.viewmodel.ext.android.viewModel


class NationalFragment : BaseFragment<FragmentNationalBinding>() {

    private val viewModelF by viewModel<NationalViewModel>()
    private val adapter by lazy {
        NationalAdapter().apply {
            listener = object : NationalListener {
                override fun onClickItem(position: Int, national: National) {
                    select(national)
                }

                override fun onLongClickItem(position: Int, national: National): Boolean {
                    return super.onLongClickItem(position, national)
                }

                override fun onDeleteItem(position: Int, national: National) {
                }
            }

            onLoadMore = {

            }
        }
    }

    override fun getLayoutId() = R.layout.fragment_national

    override fun isAttachMenuToFragment() = true

    override fun setup() {
        viewModelF.getList()
    }

    override fun initBinding() {
        binding.adapter = adapter
    }

    override fun initView() {

    }

    override fun observerViewModel() {
        observer(adapter.liveSelect) {
            logd(it.toString())
        }
        observer(viewModelF.liveNationals) {
            adapter.submitList(it)
        }
    }

    override fun onBackPressed() {
        requireActivity().finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_select_all -> {
                val selects = adapter.liveSelect.value
                selects?.let { stack ->
                    if (stack.isEmpty()) {
                        adapter.selectAll()
                    } else {
                        adapter.clearAll()
                    }
                }
                true
            }
            R.id.menu_refresh -> {
                val selects = adapter.liveSelect.value
                selects?.let { stack ->
                    if (stack.isEmpty()) {
                        toast("No item selected")
                    } else {
                        adapter.clearAll()
                    }
                }
                true
            }
            R.id.menu_delete -> {
                val selects = adapter.liveSelect.value
                selects?.let { stack ->
                    if (stack.isEmpty()) {
                        toast("No item selected")
                    } else {
                        stack.forEach {
                            viewModelF.remove(it)
                        }
                        adapter.clearAll()
                        viewModelF.postSelf()
                    }
                }
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}
