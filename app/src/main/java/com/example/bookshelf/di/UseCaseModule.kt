package com.example.bookshelf.di

import com.example.bookshelf.domain.repository.books.BookRepository
import com.example.bookshelf.domain.usecase.addUpdateBook.AddUpdateBookUseCase
import com.example.bookshelf.domain.usecase.addUpdateBook.AddUpdateBookUseCaseImpl
import com.example.bookshelf.domain.usecase.books.BooksUseCase
import com.example.bookshelf.domain.usecase.books.BooksUseCaseImpl
import com.example.bookshelf.domain.usecase.getBookDetails.GetBookDetailsUseCase
import com.example.bookshelf.domain.usecase.getBookDetails.GetBookDetailsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideBooksUseCase(bookRepository: BookRepository): BooksUseCase = BooksUseCaseImpl(bookRepository)

    @Provides
    @Singleton
    fun provideAddUpdateBookUseCase(bookRepository: BookRepository): AddUpdateBookUseCase =
        AddUpdateBookUseCaseImpl(bookRepository)

    @Provides
    @Singleton
    fun provideGetBookDetailsUseCase(bookRepository: BookRepository): GetBookDetailsUseCase =
        GetBookDetailsUseCaseImpl(bookRepository)
}