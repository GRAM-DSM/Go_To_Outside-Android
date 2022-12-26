package com.gram.domain.repository

import com.gram.domain.parameter.user.LoginParameter

interface UserRepository {

    suspend fun registerAsStudent()

    suspend fun registerAsTeacher()

    suspend fun login(
        loginParameter: LoginParameter,
    )
}