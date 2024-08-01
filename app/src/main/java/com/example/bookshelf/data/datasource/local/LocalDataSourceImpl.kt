package com.example.bookshelf.data.datasource.local

import androidx.lifecycle.LiveData
import com.example.bookshelf.data.entity.books.BookEntity
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val booksDao: BooksDao) : LocalDataSource {
    override suspend fun books(): LiveData<List<BookEntity>> = booksDao.books()

    override suspend fun insertAllBooks(books: List<BookEntity>) = booksDao.insertAllBooks(books)

    override suspend fun addBook(bookEntity: BookEntity) = booksDao.insertBook(bookEntity)

    override suspend fun updateBook(bookEntity: BookEntity) = booksDao.updateBook(bookEntity)

    override suspend fun getBookById(bookId: Int): LiveData<BookEntity?> = booksDao.getBookById(bookId)

}