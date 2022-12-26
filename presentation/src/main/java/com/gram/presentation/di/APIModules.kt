package com.gram.presentation.di

import com.gram.data.remote.api.UserAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object APIModules {

    @Provides
    @Singleton
    fun provideUserApi(
        retrofit: Retrofit,
    ): UserAPI {
        return retrofit.create(UserAPI::class.java)
    }
}