package com.gram.data.remote.datasource.user

import com.gram.data.remote.request.user.LoginRequest
import com.gram.data.remote.response.user.LoginResponse

interface UserDataSource {

    suspend fun login(
        loginRequest: LoginRequest,
    ): LoginResponse

    // todo register
}