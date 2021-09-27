package com.droiddev.cleanarchitecture.data.repository

import com.droiddev.cleanarchitecture.data.storage.User
import com.droiddev.cleanarchitecture.data.storage.UserStorage
import com.droiddev.cleanarchitecture.domain.model.SaveUser
import com.droiddev.cleanarchitecture.domain.model.UserName
import com.droiddev.cleanarchitecture.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParams: SaveUser): Boolean {
        val user = mapToStorage(saveParams)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParams: SaveUser): User {
        return User(firsName = saveParams.name, lastName = "")
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firsName, lastName = user.lastName)

    }

}