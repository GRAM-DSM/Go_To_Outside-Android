package com.gram.presentation.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModules {

    // TODO remove BASE_URL
    private val BASE_URL = "http://15.165.173.216"

/*    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor() {

    }*/

    @Provides
    @Singleton
    fun provideRetrofit(
        //okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            //.client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}