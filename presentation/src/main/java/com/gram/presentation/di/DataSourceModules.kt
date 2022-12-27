package com.gram.presentation.di

import com.gram.data.remote.datasource.user.UserDataSource
import com.gram.data.remote.datasource.user.UserDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModules {

    @Singleton
    @Binds
    abstract fun provideUserDataSource(
        userDataSourceImpl: UserDataSourceImpl,
    ): UserDataSource
}

