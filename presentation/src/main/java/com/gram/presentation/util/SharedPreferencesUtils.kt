package com.gram.presentation.util

import android.content.SharedPreferences
import com.gram.domain.entity.user.LoginEntity
import com.gram.presentation.util.SharedPreferenceKeys.ACCESS_TOKEN
import com.gram.presentation.util.SharedPreferenceKeys.AUTHORITY
import com.gram.presentation.util.SharedPreferenceKeys.REFRESH_TOKEN

object SharedPreferenceNames {

    const val DEFAULT_SHARED_PREFERENCES = "default"
}

object SharedPreferenceKeys {

    const val ACCESS_TOKEN = "access_token"
    const val REFRESH_TOKEN = "refresh_token"

    const val AUTHORITY = "authority"
}

object SharedPreferencesUtil {

    internal var sharedPreferences: SharedPreferences? = null

    internal val sharedPreferencesEditor by lazy {
        checkNotNull(sharedPreferences)
        sharedPreferences!!.edit()
    }
}

internal fun saveTokenInLocalDataBase(
    loginEntity: LoginEntity,
) {
    with(loginEntity) {
        SharedPreferencesUtil.sharedPreferencesEditor.apply {
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
            print(
                """
                saved tokens;
                access_token : $access_token
                refresh_token : $refresh_token
                authority : ${authority.toString()}
            """.trimIndent()
            )
        }.apply()
    }
}