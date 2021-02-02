package com.dev.anhnd.android_mvvm_di.di.koin.module;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\b\u0010\f\u001a\u00020\rH\u0002\u001a\b\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\rH\u0002\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0013"}, d2 = {"appModule", "Lorg/koin/core/module/Module;", "getAppModule", "()Lorg/koin/core/module/Module;", "provideApiHelper", "Lcom/dev/anhnd/android_mvvm_di/data/remote/ApiHelper;", "apiHelper", "Lcom/dev/anhnd/android_mvvm_di/data/remote/ApiHelperImpl;", "provideApiService", "Lcom/dev/anhnd/android_mvvm_di/data/remote/ApiService;", "retrofit", "Lretrofit2/Retrofit;", "provideBaseUrl", "", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "provideRetrofit", "okHttpClient", "BASE_URL", "android-mvvm-di_debug"})
public final class ApplicationModuleKt {
    @org.jetbrains.annotations.NotNull()
    private static final org.koin.core.module.Module appModule = null;
    
    @org.jetbrains.annotations.NotNull()
    public static final org.koin.core.module.Module getAppModule() {
        return null;
    }
    
    private static final java.lang.String provideBaseUrl() {
        return null;
    }
    
    private static final okhttp3.OkHttpClient provideOkHttpClient() {
        return null;
    }
    
    private static final retrofit2.Retrofit provideRetrofit(okhttp3.OkHttpClient okHttpClient, java.lang.String BASE_URL) {
        return null;
    }
    
    private static final com.dev.anhnd.android_mvvm_di.data.remote.ApiService provideApiService(retrofit2.Retrofit retrofit) {
        return null;
    }
    
    private static final com.dev.anhnd.android_mvvm_di.data.remote.ApiHelper provideApiHelper(com.dev.anhnd.android_mvvm_di.data.remote.ApiHelperImpl apiHelper) {
        return null;
    }
}