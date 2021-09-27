package com.droiddev.cleanarchitecture.domain.repository

import com.droiddev.cleanarchitecture.domain.model.SaveUser
import com.droiddev.cleanarchitecture.domain.model.UserName

interface UserRepository {

    fun saveName(saveParams: SaveUser): Boolean

    fun getName(): UserName
}