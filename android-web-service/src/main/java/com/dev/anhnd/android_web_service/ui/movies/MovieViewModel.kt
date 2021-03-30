package com.dev.anhnd.android_web_service.ui.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dev.anhnd.android_web_service.data.model.ApiDetail
import com.dev.anhnd.android_web_service.data.model.movies.Movies
import com.dev.anhnd.android_web_service.data.source.repository.MovieRepository
import com.dev.anhnd.android_web_service.utils.Constant
import com.dev.anhnd.android_web_service.utils.DataUtils
import com.dev.anhnd.mybase.BaseViewModel
import com.dev.anhnd.mybase.utils.app.asLiveData
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MovieViewModel(
    private val movieRepository: MovieRepository,
) : BaseViewModel() {

    //region api movie detail
    private val _movieDetail = MutableLiveData<MutableList<ApiDetail>>()
    val movieDetail = _movieDetail.asLiveData()
    //endregion

    //region now playing
    private val _nowPlaying = MutableLiveData<Movies>()
    val nowPlaying = _nowPlaying.asLiveData()
    //endregion

    //region popular
    private val _popular = MutableLiveData<Movies>()
    val movies = _popular.asLiveData()
    //endregion

    //region popular
    private val _topRated = MutableLiveData<Movies>()
    val topRated = _topRated.asLiveData()
    //endregion

    //region popular
    private val _upcoming = MutableLiveData<Movies>()
    val upcoming = _upcoming.asLiveData()
    //endregion


    fun getMovieDetail() {
        _movieDetail.value = DataUtils.apiMovies
    }

    fun getNowPlaying() {
        viewModelScope.launch {
            movieRepository.getNowPlaying(Constant.API_KEY).collect {
                _nowPlaying.postValue(it)
            }
        }
    }

    fun getPopular() {
        viewModelScope.launch {
            movieRepository.getPopular(Constant.API_KEY).collect {
                _popular.postValue(it)
            }
        }
    }

    fun getTopRated() {
        viewModelScope.launch {
            movieRepository.getTopRated(Constant.API_KEY).collect {
                _topRated.postValue(it)
            }
        }
    }

    fun getUpcoming() {
        viewModelScope.launch {
            movieRepository.getUpcoming(Constant.API_KEY).collect {
                _upcoming.postValue(it)
            }
        }
    }


}
