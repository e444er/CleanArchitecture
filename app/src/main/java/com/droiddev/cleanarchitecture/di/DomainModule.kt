package com.droiddev.cleanarchitecture.di

import com.droiddev.cleanarchitecture.domain.repository.UserRepository
import com.droiddev.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.droiddev.cleanarchitecture.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideUserStorage(userRepository: UserRepository): GetUserNameUseCase {
        return GetUserNameUseCase(userRepository)
    }

    @Provides
    fun provideUserRepository(userRepository: UserRepository): SaveUserNameUseCase {
        return SaveUserNameUseCase(userRepository)
    }
}