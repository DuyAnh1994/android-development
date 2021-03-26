package com.dev.anhnd.android_web_service.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dev.anhnd.android_web_service.model.ApiDetail
import com.dev.anhnd.android_web_service.model.movies.Movies
import com.dev.anhnd.android_web_service.repository.MovieRepository
import com.dev.anhnd.android_web_service.utils.Constant
import com.dev.anhnd.android_web_service.utils.DataUtils
import com.dev.anhnd.mybase.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MovieViewModel(
    private val movieRepository: MovieRepository,
) : BaseViewModel() {


    //region api movie detail
    private val _movieDetail by lazy {
        MutableLiveData<List<ApiDetail>>()
    }
    val movieDetail: LiveData<List<ApiDetail>> = _movieDetail
    //endregion

    //region now playing
    private val _nowPlaying by lazy {
        MutableLiveData<Movies>()
    }
    val nowPlaying: LiveData<Movies> = _nowPlaying
    //endregion

    //region popular
    private val _popular by lazy {
        MutableLiveData<Movies>()
    }
    val movies: LiveData<Movies> = _popular
    //endregion

    //region popular
    private val _topRated by lazy {
        MutableLiveData<Movies>()
    }
    val topRated: LiveData<Movies> = _topRated
    //endregion

    //region popular
    private val _upcoming by lazy {
        MutableLiveData<Movies>()
    }
    val upcoming: LiveData<Movies> = _upcoming
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
