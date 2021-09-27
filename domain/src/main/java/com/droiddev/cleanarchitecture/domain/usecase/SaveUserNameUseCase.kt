package com.droiddev.cleanarchitecture.domain.usecase

import com.droiddev.cleanarchitecture.domain.model.SaveUser
import com.droiddev.cleanarchitecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUser): Boolean {
        val result: Boolean = userRepository.saveName(saveParams = param)
        return result
    }
}