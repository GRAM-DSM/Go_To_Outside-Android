package com.gram.domain.entity.user

data class LoginEntity(
    val access_token: String,
    val refresh_token: String,
    val authority: Authority,
) {
    enum class Authority {
        STUDENT, TEACHER, ;
    }
}
