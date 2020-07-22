package com.hilt.demo.di

import com.hilt.demo.repository.CoroutineHelper
import com.hilt.demo.repository.NetworkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ActivityRetainedComponent::class)
object NetworkRepositoryModule {

    @Provides
    fun provideRepository(apiService: NetworkAPIService) = NetworkRepository(apiService)

  @Provides
  fun provideCoroutineDispatcher() =  CoroutineHelper().fetchCoroutineDispatcher()
}