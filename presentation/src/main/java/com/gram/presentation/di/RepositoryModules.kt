package com.gram.presentation.di

import com.gram.data.repository.PassRepositoryImpl
import com.gram.data.repository.UserRepositoryImpl
import com.gram.domain.repository.PassRepository
import com.gram.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModules {

    @Binds
    abstract fun providesUserRepository(
        userRepositoryImpl: UserRepositoryImpl,
    ): UserRepository

    @Binds
    abstract fun providesPassRepository(
        passRepositoryImpl: PassRepositoryImpl,
    ): PassRepository
}