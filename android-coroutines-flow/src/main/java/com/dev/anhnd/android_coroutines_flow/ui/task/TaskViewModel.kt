package com.dev.anhnd.android_coroutines_flow.ui.task

/*
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.dev.anhnd.android_coroutines_flow.data.local.AppPreferencesManager
import com.dev.anhnd.android_coroutines_flow.data.local.Task
import com.dev.anhnd.android_coroutines_flow.data.local.TaskDao
import com.dev.anhnd.mybase.BaseViewModel
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch

class TaskViewModel @ViewModelInject constructor(
    private val taskDao: TaskDao,
    private val preferencesManager : AppPreferencesManager
) : BaseViewModel() {

    val preferencesFlow = preferencesManager.preferencesFlow

    val liveSearchQuery by lazy {
        MutableLiveData("")
    }

    val liveSortOrder by lazy {
        MutableLiveData(SortOrder.BY_NAME)
    }

    val liveHideCompleted by lazy {
        MutableLiveData(false)
    }

    private val tasksFlow = combine(
        liveSearchQuery.asFlow(),
        preferencesFlow
    ) { searchQuery, filterPreferences ->
        Pair(searchQuery, filterPreferences)
    }.flatMapLatest { (searchQuery, filterPreferences)->
        taskDao.getTasks(searchQuery, filterPreferences.sortOrderOrder, filterPreferences.hideCompleted)
    }

    val tasks = tasksFlow.asLiveData()

    fun update(task: Task) {
        viewModelScope.launch {
            taskDao.update(task)
        }
    }

    fun delete(task: Task) {
        viewModelScope.launch {
            taskDao.delete(task)
        }
    }

    fun onSortOrderSelected(sortOrder: SortOrder) {
        viewModelScope.launch {
            preferencesManager.updateSortOrder(sortOrder)
        }
    }

    fun onHideCompletedClick(hideCompleted:Boolean) {
        viewModelScope.launch {
            preferencesManager.updateHideCompleted(hideCompleted)
        }
    }
}*/
