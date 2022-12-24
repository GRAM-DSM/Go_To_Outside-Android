package com.gram.domain.repository

interface UserRepository {

    fun registerAsStudent()

    fun registerAsTeacher()

    fun login()
}