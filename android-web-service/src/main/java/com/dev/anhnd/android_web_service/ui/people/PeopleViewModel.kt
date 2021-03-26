package com.dev.anhnd.android_web_service.ui.people

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dev.anhnd.android_web_service.model.ApiDetail
import com.dev.anhnd.android_web_service.model.people.People
import com.dev.anhnd.android_web_service.repository.PeopleRepository
import com.dev.anhnd.android_web_service.utils.Constant
import com.dev.anhnd.android_web_service.utils.DataUtils
import com.dev.anhnd.mybase.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PeopleViewModel(
    private val peopleRepository: PeopleRepository,
) : BaseViewModel() {

    //region api people detail
    private val _peopleDetail by lazy {
        MutableLiveData<List<ApiDetail>>()
    }
    val peopleDetail: LiveData<List<ApiDetail>> = _peopleDetail
    //endregion


    //region popular
    private val _popular by lazy {
        MutableLiveData<People>()
    }
    val popular: LiveData<People> = _popular
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
