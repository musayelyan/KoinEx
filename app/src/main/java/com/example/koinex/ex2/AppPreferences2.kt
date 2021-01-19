package com.example.koinex.ex2

import android.content.Context
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

// Approach 2
@KoinApiExtension
class AppPreferences2 : KoinComponent {

    val context: Context by inject<Context>()

    companion object {
        const val SHARED_PREF = "shared_pref"
        const val PROFILE_NAME = "profile_name"
    }

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)

    fun saveProfileName(name: String) {
        sharedPreferences.edit().putString(PROFILE_NAME, name).apply()
    }

    fun getProfileName(name: String): String = sharedPreferences.getString(PROFILE_NAME, "") ?: ""
}