package com.example.bookshelf.di

import android.content.Context
import androidx.room.Room
import com.example.bookshelf.data.datasource.local.BooksDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDatabaseModule {
    @Singleton
    @Provides
    fun provideYourDatabase(@ApplicationContext applicationContext: Context) = Room.databaseBuilder(
        applicationContext, BooksDatabase::class.java,
        "bookshelf"
    ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideBooksDao(db: BooksDatabase) = db.booksDao()
}