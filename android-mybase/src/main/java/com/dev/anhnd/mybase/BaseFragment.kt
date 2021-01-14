package com.dev.anhnd.mybase

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.dev.anhnd.mybase.utils.log.LogDebug

abstract class BaseFragment<DB : ViewDataBinding, A : BaseActivity<*>> : Fragment(), BaseView, View.OnClickListener {

    companion object {
        private val TAG = BaseFragment::class.java.simpleName
    }

    //region Properties
    @Suppress("UNCHECKED_CAST")
    val mainActivity by lazy {
        requireActivity() as A
    }
    protected lateinit var binding: DB
    protected lateinit var screenTransitionManageImp: ScreenTransitionManageImp
    private var safeAction = false
    private var waitingAction: (() -> Unit)? = null
    private lateinit var callback: OnBackPressedCallback
    //endregion

    //region Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setup(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewListener, this)
        initBinding()
        return binding.root
    }

    override fun onViewCreated(view: View,
                               savedInstanceState: Bundle?) {
        beforeInitView()
        super.onViewCreated(view, savedInstanceState)
        if (isEnableBackPress()) {
            setBackPressedDispatcher()
        }
        screenTransitionManageImp = initScreenTransitionManager()
        initView(view, savedInstanceState)
        observerViewModel()
    }

    override fun onResume() {
        super.onResume()
        safeAction = true
        if (waitingAction != null) {
            waitingAction?.invoke()
            waitingAction = null
        }
    }

    override fun onPause() {
        super.onPause()
        safeAction = false
    }
    //endregion

    override fun beforeInitView() {
        if (getStatusBarColor() != null && isDarkText() != null) {
            setStatusColor(getStatusBarColor()!!, isDarkText()!!)
        }
    }

    override fun onClick(v: View?) {
        v?.let { view ->
            onViewClick(view.id)
        }
    }

    open fun isEnableBackPress(): Boolean {
        return true
    }

    open fun getStatusBarColor(): Int? {
        return null
    }

    open fun isDarkText(): Boolean? {
        return null
    }

    open fun backScreen() {
        navigateUp()
    }

    open fun getContainer(): Int {
        return -1
    }

    open fun onBackPressed() {

    }

    fun safeAction(action: () -> Unit) {
        if (safeAction) action.invoke()
        else waitingAction = action
    }

    fun popBackStack(tag: String) {
        val backTag = if (tag.isEmpty()) javaClass.simpleName else tag
        requireActivity().supportFragmentManager.popBackStack(
            backTag,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
    }

    private fun navigateUp() {
        try {
            findNavController().navigateUp()
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            LogDebug.e(this::class.java.simpleName, "${e.message}")
        } catch (e: Exception) {
            e.printStackTrace()
            LogDebug.e(this::class.java.simpleName, "${e.message}")
        }
    }

    fun navigateTo(actionId: Int,
                   args: Bundle? = null) {
        try {
            with(findNavController()) {
                currentDestination?.getAction(actionId)?.let {
                    if (currentDestination?.id != currentDestination?.getAction(actionId)?.destinationId) {
                        navigate(actionId, args)
                    }
                }
            }
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            LogDebug.e(TAG, "${e.message}")
        } catch (e: Exception) {
            e.printStackTrace()
            LogDebug.e(TAG, "${e.message}")
        }
    }

    fun popBackStack(actionId: Int, popIdFragment: Boolean = false) {
        try {
            findNavController().popBackStack(actionId, popIdFragment)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            LogDebug.e(TAG, "${e.message}")
        } catch (e: Exception) {
            e.printStackTrace()
            LogDebug.e(TAG, "${e.message}")
        }
    }

    private fun initScreenTransitionManager(): ScreenTransitionManageImp {
        return ScreenTransitionManageImp(requireActivity().supportFragmentManager, getContainer())
    }

    private fun setBackPressedDispatcher() {
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }

    private fun setStatusColor(color: Int = Color.BLACK, state: Boolean = true) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val window = activity?.window
            window?.let { w ->
                w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                var newUiVisibility = w.decorView.systemUiVisibility
                newUiVisibility = if (state) {
                    //Dark Text to show up on your light status bar
                    newUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                } else {
                    //Light Text to show up on your dark status bar
                    newUiVisibility and (View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR).inv()
                }
                w.decorView.systemUiVisibility = newUiVisibility
                w.statusBarColor = color
            }
        }
    }
}