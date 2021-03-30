package com.dev.anhnd.android_mvvm_di.ui.notes.note_detail

import androidx.fragment.app.activityViewModels
import com.dev.anhnd.android_mvvm_di.R
import com.dev.anhnd.android_mvvm_di.databinding.FragmentNotesDetailBinding
import com.dev.anhnd.android_mvvm_di.ui.main.MainViewModel
import com.dev.anhnd.mybase.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesDetailFragment : BaseFragment<FragmentNotesDetailBinding>() {

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun getLayoutId() = R.layout.fragment_notes_detail

    override fun initBinding() {
        binding.mainViewModel = mainViewModel
    }

    override fun initView() {

    }

    override fun observerViewModel() {

    }

    override fun onBackPressed() {
        backScreen()
    }
}
