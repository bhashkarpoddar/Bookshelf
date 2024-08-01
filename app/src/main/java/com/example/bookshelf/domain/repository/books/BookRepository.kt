package com.example.bookshelf.domain.repository.books

import androidx.lifecycle.LiveData
import com.example.bookshelf.data.dto.books.BooksDTO
import com.example.bookshelf.data.entity.books.BookEntity
import com.example.bookshelf.domain.model.networkResult.NetworkResult

interface BookRepository {
    suspend fun refreshBooks(): NetworkResult<BooksDTO>
    suspend fun books(): LiveData<List<BookEntity>>
    suspend fun insertAllBooks(books: List<BookEntity>)
    suspend fun addBook(bookEntity: BookEntity)
    suspend fun updateBook(bookEntity: BookEntity)
    suspend fun getBookById(bookId: Int): LiveData<BookEntity?>
}