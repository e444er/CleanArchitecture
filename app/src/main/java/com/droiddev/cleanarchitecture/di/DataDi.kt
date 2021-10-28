package com.droiddev.cleanarchitecture.di

import com.droiddev.cleanarchitecture.data.repository.UserRepositoryImpl
import com.droiddev.cleanarchitecture.data.storage.SharedPrefUserStorage
import com.droiddev.cleanarchitecture.data.storage.UserStorage
import com.droiddev.cleanarchitecture.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}