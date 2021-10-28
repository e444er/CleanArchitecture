package com.droiddev.cleanarchitecture.di

import com.droiddev.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.droiddev.cleanarchitecture.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }
}