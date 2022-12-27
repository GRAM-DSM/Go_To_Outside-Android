package com.gram.presentation.util

import android.content.SharedPreferences
import com.gram.domain.entity.user.LoginEntity
import com.gram.presentation.util.SharedPreferenceKeys.ACCESS_TOKEN
import com.gram.presentation.util.SharedPreferenceKeys.AUTHORITY
import com.gram.presentation.util.SharedPreferenceKeys.IS_LOGGED_IN
import com.gram.presentation.util.SharedPreferenceKeys.LOGGED_IN_AUTHORITY
import com.gram.presentation.util.SharedPreferenceKeys.REFRESH_TOKEN

object SharedPreferenceNames {

    const val DEFAULT_SHARED_PREFERENCES = "default"
}

object SharedPreferenceKeys {

    const val ACCESS_TOKEN = "access_token"
    const val REFRESH_TOKEN = "refresh_token"

    const val AUTHORITY = "authority"

    const val IS_LOGGED_IN = "is_logged_in"
    const val LOGGED_IN_AUTHORITY = "logged_in_authority"
}

internal var sharedPreferences: SharedPreferences? = null

internal val sharedPreferencesEditor by lazy {
    requireNotNull(sharedPreferences)
    sharedPreferences!!.edit()
}

internal fun setLoggedIn(authority: LoginEntity.Authority) {
    sharedPreferencesEditor.run {
        putBoolean(
            IS_LOGGED_IN,
            true,
        )
        putString(
            LOGGED_IN_AUTHORITY,
            authority.toString().also {
                println(
                    """
                    authority : $it
                """.trimIndent()
                )
            }
        )
    }
}

internal fun setLoggedOut() {
    sharedPreferencesEditor.apply {
        putBoolean(
            IS_LOGGED_IN,
            false,
        )
    }
}

internal fun saveTokenInLocalDataBase(
    loginEntity: LoginEntity,
) {
    with(loginEntity) {
        sharedPreferencesEditor.apply {
            putString(
                ACCESS_TOKEN,
                access_token,
            )
            putString(
                REFRESH_TOKEN,
                refresh_token,
            )
            putString(
                AUTHORITY,
                authority.toString(),
            )
            println(
                """
                saved tokens {
                access_token : $access_token
                refresh_token : $refresh_token
                authority : $authority
                }
            """.trimIndent()
            )
        }.apply()
    }
}