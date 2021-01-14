package com.dev.anhnd.android_mvvm_di.ui.notes.note_detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.dev.anhnd.android_mvvm_di.R
import com.dev.anhnd.android_mvvm_di.databinding.FragmentNotesDetailBinding
import com.dev.anhnd.android_mvvm_di.ui.main.MainActivity
import com.dev.anhnd.android_mvvm_di.ui.main.MainViewModel
import com.dev.anhnd.mybase.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesDetailFragment() : BaseFragment<FragmentNotesDetailBinding, MainActivity>() {

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun getLayoutId() = R.layout.fragment_notes_detail

    override fun initBinding() {
        binding.mainViewModel = mainViewModel
    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {

    }

    override fun observerViewModel() {

    }

    override fun onBackPressed() {
        backScreen()
    }
}
