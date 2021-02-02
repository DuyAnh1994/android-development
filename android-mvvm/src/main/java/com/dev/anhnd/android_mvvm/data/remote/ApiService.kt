package com.dev.anhnd.android_mvvm.data.remote

import com.dev.anhnd.android_mvvm.model.Photos
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
//    @GET( "/photos?albumId=1")
    @GET( "/photos")
   fun getPhotos(): Call<List<Photos>>
}
