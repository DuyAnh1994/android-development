package com.dev.anhnd.android_mvvm.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.dev.anhnd.android_mvvm.R
import com.dev.anhnd.android_mvvm.databinding.FragmentHomeBinding
import com.dev.anhnd.android_mvvm.model.Color
import com.dev.anhnd.android_mvvm.model.Image
import com.dev.anhnd.android_mvvm.model.Photos
import com.dev.anhnd.android_mvvm.model.Text
import com.dev.anhnd.android_mvvm.ui.dialog.DeleteDialog
import com.dev.anhnd.android_mvvm.ui.dialog.SaveDialog
import com.dev.anhnd.android_mvvm.ui.main.ItemNewsListener
import com.dev.anhnd.android_mvvm.ui.main.MainActivity
import com.dev.anhnd.mybase.BaseDiffCallback
import com.dev.anhnd.mybase.BaseFragment
import com.dev.anhnd.mybase.BaseMultiHolderAdapter
import com.dev.anhnd.mybase.utils.app.observer
import com.dev.anhnd.mybase.utils.log.logd
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, MainActivity>() {

    private val viewModel by viewModels<HomeViewModel>()

    private val dialogDelete by lazy {
        DeleteDialog()
    }

    private val dialogSave by lazy {
        SaveDialog()
    }

    //region single holder adapter
    private val adapter by lazy {
        PhotosAdapter(R.layout.item_photo, PhotosDiffUtilsImpl())
    }

    private class PhotosDiffUtilsImpl : BaseDiffCallback<Photos>() {
        override fun areItemsTheSame(oldItem: Photos, newItem: Photos): Boolean {
            return super.areItemsTheSame(oldItem, newItem)
        }

        override fun areContentsTheSame(oldItem: Photos, newItem: Photos): Boolean {
            return super.areContentsTheSame(oldItem, newItem)
        }
    }
    //endregion

    //region multi holder adapter
    private val adapterMulti by lazy {
        NewsAdapter(resLayouts, NewsDiffUtilsImpl()).apply {
            listener = object : ItemNewsListener {
                override fun onItemClick(v: View, item: BaseMultiHolderAdapter.ModelType, position: Int) {

                }
            }
        }
    }

    private val resLayouts = listOf(
        R.layout.item_first,
        R.layout.item_second,
        R.layout.item_third
    )

    private class NewsDiffUtilsImpl : BaseDiffCallback<BaseMultiHolderAdapter.ModelType>() {

    }
    //endregion

    override fun getLayoutId() = R.layout.fragment_home

    override fun setup(savedInstanceState: Bundle?) {
//        viewModel.getPhotos()
    }

    override fun initBinding() {
        binding.adapter = adapter
        binding.adapterMulti = adapterMulti
    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {
        val list = mutableListOf<BaseMultiHolderAdapter.ModelType>()
        list.add(Text("Some thing 1"))
        list.add(Color(R.color.colorPickerSupernova))
        list.add(Text("Some thing 2"))
        list.add(Image(R.drawable.ic_launcher_background, "https://via.placeholder.com/150/92c952"))
        list.add(Text("Some thing 3"))
        list.add(Color(R.color.colorPickerAzureRadiance))
        list.add(Text("Some thing 4"))
        list.add(Image(R.drawable.ic_launcher_foreground, "https://via.placeholder.com/150/771796"))
        list.add(Text("Some thing 5"))
//        adapterMulti.submitList(list)
    }

    override fun observerViewModel() {
        observer(viewModel.photos) {
            logd("photos size: ${it?.size}")
            adapter.submitList(it)
        }
    }

    override fun onViewClick(viewId: Int) {
        when (viewId) {
            R.id.constraintRoot -> {
//                dialogDelete.showDialog(fm = childFragmentManager, tag = DeleteDialog::class.java.simpleName)
//                dialogSave.showDialog(childFragmentManager, SaveDialog::class.java.simpleName)
            }
        }
    }
}