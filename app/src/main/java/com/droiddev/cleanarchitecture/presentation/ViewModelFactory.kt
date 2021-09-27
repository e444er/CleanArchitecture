package com.droiddev.cleanarchitecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.droiddev.cleanarchitecture.data.repository.UserRepositoryImpl
import com.droiddev.cleanarchitecture.data.storage.SharedPrefUserStorage
import com.droiddev.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.droiddev.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class ViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE)
    { UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context)) }

    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository)
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository)
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase, saveUserNameUseCase) as T
    }
}