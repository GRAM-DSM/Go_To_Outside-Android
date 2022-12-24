package com.gram.domain.repository

interface UserRepository {

    suspend fun registerAsStudent()

    suspend fun registerAsTeacher()

    fun login()
}