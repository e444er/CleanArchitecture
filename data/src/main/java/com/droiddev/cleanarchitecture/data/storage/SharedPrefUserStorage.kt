package com.droiddev.cleanarchitecture.data.storage

import android.content.Context

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_NAME = "default"

class SharedPrefUserStorage(context: Context) : UserStorage {

    private val sharedPrefrences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPrefrences.edit().putString(KEY_FIRST_NAME, user.firsName).apply()
        sharedPrefrences.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun get(): User {
        val firstName = sharedPrefrences.getString(KEY_FIRST_NAME, "") ?: ""
        val lastName = sharedPrefrences.getString(KEY_LAST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        return User(firstName, lastName)
    }
}