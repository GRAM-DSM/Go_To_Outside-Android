package com.gram.data.remote.api

import com.gram.data.request.user.LoginRequest
import com.gram.data.response.user.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {

    @POST("/login")
    suspend fun login(
        @Body loginRequest: LoginRequest,
    ): LoginResponse

    // todo register
}