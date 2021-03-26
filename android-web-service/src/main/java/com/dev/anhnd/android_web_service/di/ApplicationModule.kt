package com.dev.anhnd.android_web_service.di

import com.dev.anhnd.android_web_service.BuildConfig
import com.dev.anhnd.android_web_service.data.remote.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val applicationModule = module {
    single {
        provideBaseUrl()
    }
    single {
        provideOkHttpClient()
    }
    single {
        providerGson()
    }
    single {
        providerRetrofit(get(), get(), get())
    }
    single {
        providerApiService(get())
    }
}

private fun provideBaseUrl(): String {
    return BuildConfig.BASE_URL
}

private fun provideOkHttpClient(): OkHttpClient {
    return if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
    } else {
        OkHttpClient.Builder().build()
    }
}

private fun providerGson(): Gson {
    return GsonBuilder().setLenient().create()
}

private fun providerRetrofit(BASE_URL: String,
                             client: OkHttpClient,
                             gson: Gson): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
//        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}

private fun providerApiService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}
