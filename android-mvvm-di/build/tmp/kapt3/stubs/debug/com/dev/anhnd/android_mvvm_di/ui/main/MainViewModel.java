package com.dev.anhnd.android_mvvm_di.ui.main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0002R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/dev/anhnd/android_mvvm_di/ui/main/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "mainRepository", "Lcom/dev/anhnd/android_mvvm_di/repository/MainRepository;", "(Lcom/dev/anhnd/android_mvvm_di/repository/MainRepository;)V", "_users", "Landroidx/lifecycle/MutableLiveData;", "Lcom/dev/anhnd/android_mvvm_di/utils/Event;", "", "Lcom/dev/anhnd/android_mvvm_di/model/User;", "user", "Landroidx/lifecycle/LiveData;", "getUser", "()Landroidx/lifecycle/LiveData;", "fetchUsers", "", "android-mvvm-di_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<com.dev.anhnd.android_mvvm_di.utils.Event<java.util.List<com.dev.anhnd.android_mvvm_di.model.User>>> _users = null;
    private final com.dev.anhnd.android_mvvm_di.repository.MainRepository mainRepository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.dev.anhnd.android_mvvm_di.utils.Event<java.util.List<com.dev.anhnd.android_mvvm_di.model.User>>> getUser() {
        return null;
    }
    
    private final void fetchUsers() {
    }
    
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    com.dev.anhnd.android_mvvm_di.repository.MainRepository mainRepository) {
        super();
    }
}