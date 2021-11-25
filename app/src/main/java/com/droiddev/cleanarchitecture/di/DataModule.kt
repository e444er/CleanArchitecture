package com.droiddev.cleanarchitecture.di

import android.content.Context
import com.droiddev.cleanarchitecture.data.repository.UserRepositoryImpl
import com.droiddev.cleanarchitecture.data.storage.SharedPrefUserStorage
import com.droiddev.cleanarchitecture.data.storage.UserStorage
import com.droiddev.cleanarchitecture.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context): UserStorage{
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository{
        return UserRepositoryImpl(userStorage = userStorage)
    }


}