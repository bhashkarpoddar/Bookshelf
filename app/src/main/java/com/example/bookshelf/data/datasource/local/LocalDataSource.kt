package com.example.bookshelf.data.datasource.local

import androidx.lifecycle.LiveData
import com.example.bookshelf.data.entity.books.BookEntity
import com.example.bookshelf.domain.model.networkResult.ResponseResult

interface LocalDataSource {

    suspend fun books(): LiveData<List<BookEntity>>
    suspend fun insertAllBooks(books: List<BookEntity>)
    suspend fun addBook(bookEntity: BookEntity) : ResponseResult<Long>
    suspend fun updateBook(bookEntity: BookEntity)
    suspend fun getBookById(bookId: Int): LiveData<BookEntity?>

}