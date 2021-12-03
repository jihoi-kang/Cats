package com.jay.cats.di

import com.jay.cats.data.CatRepository
import com.jay.cats.data.CatRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideCatRepository(catRepositoryImpl: CatRepositoryImpl): CatRepository

}