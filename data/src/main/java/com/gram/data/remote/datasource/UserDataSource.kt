package com.gram.data.remote.datasource

import com.gram.data.request.user.LoginRequest
import com.gram.data.response.user.LoginResponse

interface UserDataSource {

    suspend fun login(
        loginRequest: LoginRequest,
    ): LoginResponse

    // todo register
}