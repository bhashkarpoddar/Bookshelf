package com.example.bookshelf.di

import com.example.bookshelf.data.repository.books.BookRepositoryImpl
import com.example.bookshelf.domain.repository.books.BookRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindBookRepositoryImpl(bookRepositoryImpl: BookRepositoryImpl): BookRepository

}