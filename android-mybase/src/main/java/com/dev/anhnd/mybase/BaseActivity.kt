package com.dev.anhnd.mybase

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import android.view.InflateException
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.dev.anhnd.mybase.utils.app.openAppSetting
import com.dev.anhnd.mybase.utils.log.LogDebug

abstract class BaseActivity<DB : ViewDataBinding> : AppCompatActivity(), BaseView {

    companion object {
        private val TAG = BaseActivity::class.java.simpleName
        private const val REQUEST_PERMISSION = 1
    }

    protected lateinit var binding: DB
    private var onAllow: (() -> Unit)? = null
    private var onDenied: (() -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        beforeInitView()
        super.onCreate(savedInstanceState)
        try {
            if (fixSingleTask()) {
                if (!isTaskRoot) {
                    finish()
                    return
                }
            }
            binding = DataBindingUtil.setContentView(this, getLayoutId())
            binding.lifecycleOwner = this
            initBinding()
            initView(savedInstanceState = savedInstanceState)
            observerViewModel()
        } catch (e: InflateException) {
            e.printStackTrace()
            LogDebug.e(TAG, "${e.message}")
        } catch (e: Resources.NotFoundException) {
            e.printStackTrace()
            LogDebug.e(TAG, "${e.message}")
        } catch (e: Exception) {
            e.printStackTrace()
            LogDebug.e(TAG, "${e.message}")
        }
    }

    protected open fun fixSingleTask(): Boolean = false

    fun checkPermission(permissions: Array<String>): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            permissions.forEach {
                if (checkSelfPermission(it) == PackageManager.PERMISSION_DENIED) {
                    return false
                }
            }
        }
        return true
    }

    @SuppressLint("ObsoleteSdkInt")
    protected fun doRequestPermission(permissions: Array<String>,
                                      onAllow: () -> Unit = {},
                                      onDenied: () -> Unit = {}) {
        this.onAllow = onAllow
        this.onDenied = onDenied
        if (checkPermission(permissions)) {
            onAllow()
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(permissions, REQUEST_PERMISSION)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (checkPermission(permissions)) {
            onAllow?.invoke()
        } else {
            onDenied?.invoke()
            openAppSetting(this, requestCode)
        }
    }

    fun setKeyboardVisibilityListener(parent: View, listener: OnKeyboardVisibilityListener) {
        parent.viewTreeObserver.addOnGlobalLayoutListener {
            val defaultKeyboardHeightDP = 100
            val estimatedKeyboardDP = defaultKeyboardHeightDP + if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                48
            } else {
                0
            }
            val rect = Rect()
            val estimatedKeyboardHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, estimatedKeyboardDP.toFloat(), parent.resources.displayMetrics).toInt()
            parent.getWindowVisibleDisplayFrame(rect)
            val heightDiff = parent.rootView.height - (rect.bottom - rect.top)
            val isShown = heightDiff >= estimatedKeyboardHeight
            listener.onVisibilityChanged(isShown)
        }
    }
}

interface OnKeyboardVisibilityListener {
    fun onVisibilityChanged(visible: Boolean)
}