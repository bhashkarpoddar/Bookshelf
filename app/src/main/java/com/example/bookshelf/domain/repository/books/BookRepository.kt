package com.example.bookshelf.domain.repository.books

import androidx.lifecycle.LiveData
import com.example.bookshelf.data.dto.books.BooksDTO
import com.example.bookshelf.data.entity.books.BookEntity
import com.example.bookshelf.domain.model.networkResult.ResponseResult

interface BookRepository {
    suspend fun refreshBooks(): ResponseResult<BooksDTO>
    suspend fun books(): LiveData<List<BookEntity>>
    suspend fun insertAllBooks(books: List<BookEntity>)
    suspend fun addBook(bookEntity: BookEntity): ResponseResult<Long>
    suspend fun updateBook(bookEntity: BookEntity)
    suspend fun getBookById(bookId: Int): LiveData<BookEntity?>
}