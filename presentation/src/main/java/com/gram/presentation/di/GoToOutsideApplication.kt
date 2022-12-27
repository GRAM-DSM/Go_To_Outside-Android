package com.gram.presentation.di

import android.app.Application
import com.gram.presentation.util.SharedPreferenceNames.DEFAULT_SHARED_PREFERENCES
import com.gram.presentation.util.sharedPreferences
import dagger.hilt.android.HiltAndroidApp

//@HiltAndroidApp
@HiltAndroidApp
class GoToOutsideApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        sharedPreferences = getSharedPreferences(
            DEFAULT_SHARED_PREFERENCES,
            MODE_PRIVATE,
        )
    }
}
