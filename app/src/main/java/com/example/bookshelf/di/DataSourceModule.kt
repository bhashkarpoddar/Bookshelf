package com.example.bookshelf.di

import com.example.bookshelf.data.datasource.local.LocalDataSource
import com.example.bookshelf.data.datasource.local.LocalDataSourceImpl
import com.example.bookshelf.data.datasource.remote.RemoteSource
import com.example.bookshelf.data.datasource.remote.RemoteSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    @Singleton
    fun bindRemoteSourceImpl(remoteImpl: RemoteSourceImpl): RemoteSource

    @Binds
    @Singleton
    fun bindLocalDataSourceImpl(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource
}