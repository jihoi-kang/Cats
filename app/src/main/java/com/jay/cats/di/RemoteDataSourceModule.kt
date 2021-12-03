package com.jay.cats.di

import com.jay.cats.data.CatRemoteDataSource
import com.jay.cats.data.CatRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RemoteDataSourceModule {

    @Binds
    @Singleton
    abstract fun provideCatRemoteDataSource(catRemoteDataSourceImpl: CatRemoteDataSourceImpl): CatRemoteDataSource

}