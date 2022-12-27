package com.gram.data.remote.api

import com.gram.data.remote.request.user.LoginRequest
import com.gram.data.remote.response.user.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {

    @POST("/auth/login")
    suspend fun login(
        @Body loginRequest: LoginRequest,
    ): LoginResponse

    // todo register
}