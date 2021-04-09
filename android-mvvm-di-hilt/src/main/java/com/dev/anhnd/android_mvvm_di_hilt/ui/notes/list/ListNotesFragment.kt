package com.dev.anhnd.android_mvvm_di_hilt.ui.notes.list

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.dev.anhnd.android_mvvm_di_hilt.R
import com.dev.anhnd.android_mvvm_di_hilt.data.source.local.entity.Notes
import com.dev.anhnd.android_mvvm_di_hilt.databinding.FragmentListNotesBinding
import com.dev.anhnd.android_mvvm_di_hilt.ui.main.MainViewModel
import com.dev.anhnd.mybase.BaseFragment
import com.dev.anhnd.mybase.utils.app.observer
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
@WithFragmentBindings
class ListNotesFragment : BaseFragment<FragmentListNotesBinding>() {

    private val mainViewModel by activityViewModels<MainViewModel>()
    private val viewModel by viewModels<ListNotesViewModel>()
    private val adapter by lazy {
        NotesAdapter().apply {
            listener = object : ListNotesListener {
                override fun onClickItem(position: Int, item: Notes) {
                    select(item)
                }

                override fun onLongClickItem(position: Int, item: Notes): Boolean {
                    unSelect(item)
                    viewModel.delete(item)
                    return super.onLongClickItem(position, item)
                }
            }
        }
    }

    override fun getLayoutId() = R.layout.fragment_list_notes

    override fun initBinding() {
        binding.adapter = adapter
        binding.mainViewModel = mainViewModel
        binding.viewModel = viewModel
    }

    override fun initView() {
    }

    override fun observerViewModel() {
        observer(viewModel.notes) {
            adapter.submitList(it)
        }
    }

    override fun onViewClick(viewId: Int) {
        when (viewId) {
            R.id.btnAddNotes -> {
                navigateTo(R.id.action_listNotesFragment_to_addNotesFragment)
            }
        }
    }

    override fun onBackPressed() {
        activityOwner.finish()
    }
}
