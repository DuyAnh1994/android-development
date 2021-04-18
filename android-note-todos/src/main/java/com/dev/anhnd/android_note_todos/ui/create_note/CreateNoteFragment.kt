package com.dev.anhnd.android_note_todos.ui.create_note

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.dev.anhnd.android_note_todos.R
import com.dev.anhnd.android_note_todos.databinding.FragmentCreateNoteBinding
import com.dev.anhnd.android_note_todos.databinding.FragmentHomeBinding
import com.dev.anhnd.android_note_todos.ui.home.HomeViewModel
import com.dev.anhnd.android_note_todos.ui.main.MainViewModel
import com.dev.anhnd.mybase.BaseFragment
import com.dev.anhnd.mybase.utils.app.observer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateNoteFragment : BaseFragment<FragmentCreateNoteBinding>() {

    private val mainViewModel by activityViewModels<MainViewModel>()
    private val viewModelF by viewModels<CreateNoteViewModel>()


    override fun getLayoutId() = R.layout.fragment_create_note


    override fun initBinding() {
        binding.mainViewModel = mainViewModel
        binding.viewModelF = viewModelF
    }

    override fun initView() {

    }

    override fun observerViewModel() {

    }

    override fun onViewClick(viewId: Int) {

    }

    override fun onBackPressed() {
        backScreen()
    }

}