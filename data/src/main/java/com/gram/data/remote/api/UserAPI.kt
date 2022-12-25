package com.gram.data.remote.api

import com.gram.data.request.user.LoginRequest
import com.gram.data.response.user.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET

interface UserAPI {

    @GET("/login")
    suspend fun login(
        @Body loginRequest: LoginRequest,
    ): LoginResponse

    // todo register
}