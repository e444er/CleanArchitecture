package com.droiddev.cleanarchitecture.domain.usecase

import com.droiddev.cleanarchitecture.domain.model.UserName
import com.droiddev.cleanarchitecture.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}