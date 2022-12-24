package com.gram.domain.repository

interface PassRepository {

    suspend fun applyPass()

    suspend fun referPass()

    suspend fun referPassesList()

    suspend fun permitPass()
}