package com.dev.anhnd.android_web_service.ui.people

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dev.anhnd.android_web_service.data.model.ApiDetail
import com.dev.anhnd.android_web_service.data.model.people.People
import com.dev.anhnd.android_web_service.data.source.repository.PeopleRepository
import com.dev.anhnd.android_web_service.utils.Constant
import com.dev.anhnd.android_web_service.utils.DataUtils
import com.dev.anhnd.mybase.BaseViewModel
import com.dev.anhnd.mybase.utils.app.asLiveData
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PeopleViewModel(
    private val peopleRepository: PeopleRepository,
) : BaseViewModel() {

    //region api people detail
    private val _peopleDetail = MutableLiveData<MutableList<ApiDetail>>()
    val peopleDetail = _peopleDetail.asLiveData()
    //endregion

    //region popular
    private val _popular = MutableLiveData<People>()
    val popular = _popular.asLiveData()
    //endregion

    fun getMovieDetail() {
        _peopleDetail.value = DataUtils.apiPeople
    }

    fun getPopular() {
        viewModelScope.launch {
            peopleRepository.getPopular(Constant.API_KEY).collect {
                _popular.postValue(it)
            }
        }
    }
}
