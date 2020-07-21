package com.hilt.demo.di

import com.hilt.demo.repository.NetworkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object NetworkRepositoryModule {

    @Provides
    fun provideRepository(apiService: NetworkAPIService) = NetworkRepository(apiService)
}