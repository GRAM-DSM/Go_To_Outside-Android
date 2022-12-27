package com.gram.data.remote.response.user

import com.google.gson.annotations.SerializedName
import com.gram.domain.entity.user.LoginEntity

data class LoginResponse(
    @SerializedName("access_token") val accessToken: String,
    @SerializedName("refresh_token") val refreshToken: String,
    @SerializedName("authority") val authority: LoginEntity.Authority,
)

fun LoginResponse.toLoginEntity(): LoginEntity {
    return LoginEntity(
        this.accessToken,
        this.refreshToken,
        this.authority,
    )
}