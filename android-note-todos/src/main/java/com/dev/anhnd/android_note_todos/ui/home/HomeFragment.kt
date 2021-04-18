package com.dev.anhnd.android_note_todos.ui.home

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.dev.anhnd.android_note_todos.R
import com.dev.anhnd.android_note_todos.data.model.Note
import com.dev.anhnd.android_note_todos.databinding.FragmentHomeBinding
import com.dev.anhnd.android_note_todos.ui.main.MainViewModel
import com.dev.anhnd.mybase.BaseFragment
import com.dev.anhnd.mybase.utils.app.observer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val mainViewModel by activityViewModels<MainViewModel>()
    private val viewModelF by viewModels<HomeViewModel>()
    private val adapter by lazy {
        NoteAdapter().apply {
            listener = object : NoteListener {
                override fun onClickItem(position: Int, item: Note) {
                    try {
                        mainViewModel.getNote(item.id)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    navigateTo(R.id.action_homeFragment_to_createNoteFragment)
                }

                override fun onLongClickItem(position: Int, item: Note) {

                }
            }
        }
    }

    override fun getLayoutId() = R.layout.fragment_home

    override fun setup() {
        viewModelF.getNotes()
    }

    override fun initBinding() {
        binding.mainViewModel = mainViewModel
        binding.viewModelF = viewModelF
        binding.adapter = adapter
    }

    override fun initView() {

    }

    override fun observerViewModel() {
        observer(viewModelF.notes) { notes ->
            adapter.submitList(notes)
        }
    }

    override fun onViewClick(viewId: Int) {

    }

}
