package com.example.bookshelf.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bookshelf.data.entity.books.BookEntity

@Database(entities = [BookEntity::class], version = 1, exportSchema = false)
abstract class BooksDatabase : RoomDatabase() {
    abstract fun booksDao(): BooksDao

}