package com.gram.data.remote.datasource.user

import com.gram.data.remote.api.UserAPI
import com.gram.data.remote.request.user.LoginRequest
import com.gram.data.remote.response.user.LoginResponse
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
    private val userAPI: UserAPI,
) : UserDataSource {

    override suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return userAPI.login(
            loginRequest,
        )
        /*HttpHandler<LoginResponse>().httpRequest {
            userAPI.login(
                loginRequest,
            )
        }.sendRequest()*/
    }
}