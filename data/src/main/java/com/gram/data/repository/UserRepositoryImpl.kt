package com.gram.data.repository

import com.gram.data.remote.datasource.UserDataSource
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

    override fun login(loginParameter: LoginParameter) {
        //TODO("Not yet implemented")
    }
}