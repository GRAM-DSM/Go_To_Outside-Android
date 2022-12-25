package com.gram.data.remote.datasource

import com.gram.data.remote.api.UserAPI
import com.gram.data.request.user.LoginRequest
import com.gram.data.response.user.LoginResponse
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
    private val userAPI: UserAPI,
) : UserDataSource {

    override suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return userAPI.login(
            loginRequest,
        )
    }
}