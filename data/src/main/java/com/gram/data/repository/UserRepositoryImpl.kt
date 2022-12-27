package com.gram.data.repository

import com.gram.data.remote.datasource.user.UserDataSource
import com.gram.data.remote.request.user.LoginRequest
import com.gram.data.remote.response.user.toLoginEntity
import com.gram.domain.entity.user.LoginEntity
import com.gram.domain.parameter.user.LoginParameter
import com.gram.domain.repository.UserRepository
import javax.inject.Inject


class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource,
) : UserRepository {

    override suspend fun registerAsStudent() {
        //TODO("Not yet implemented")
    }

    override suspend fun registerAsTeacher() {
        //TODO("Not yet implemented")
    }

    override suspend fun login(
        loginParameter: LoginParameter,
    ): LoginEntity{
        return userDataSource.login(
            LoginRequest(
                loginParameter.accountId,
                loginParameter.password,
            )
        ).toLoginEntity()
    }
}