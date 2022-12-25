package com.gram.data.repository

import com.gram.domain.repository.PassRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PassRepositoryImpl @Inject constructor(

) : PassRepository {

    override suspend fun applyPass() {
        TODO("Not yet implemented")
    }

    override suspend fun referPass() {
        TODO("Not yet implemented")
    }

    override suspend fun referPassesList() {
        TODO("Not yet implemented")
    }

    override suspend fun permitPass() {
        TODO("Not yet implemented")
    }
}