package com.droiddev.cleanarchitecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.droiddev.cleanarchitecture.domain.model.SaveUser
import com.droiddev.cleanarchitecture.domain.model.UserName
import com.droiddev.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.droiddev.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val _resultLive = MutableLiveData<String>()
    val resultLive: LiveData<String> = _resultLive

    fun save(text: String) {
        val params = SaveUser(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(param = params)
        _resultLive.value = "Save result = $resultData"
    }

    fun load() {
        val userName: UserName = getUserNameUseCase.execute()
        _resultLive.value = "${userName.firstName} ${userName.lastName}"
    }

}