package com.example.bookshelf.data.repository.books

import androidx.lifecycle.LiveData
import com.example.bookshelf.data.datasource.local.LocalDataSource
import com.example.bookshelf.data.datasource.remote.RemoteSource
import com.example.bookshelf.data.dto.books.BooksDTO
import com.example.bookshelf.data.entity.books.BookEntity
import com.example.bookshelf.domain.model.networkResult.NetworkResult
import com.example.bookshelf.domain.repository.books.BookRepository
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(private val remoteSource: RemoteSource, private val localDataSource: LocalDataSource): BookRepository {
    override suspend fun refreshBooks(): NetworkResult<BooksDTO> = remoteSource.books()

    override suspend fun books(): LiveData<List<BookEntity>> = localDataSource.books()

    override suspend fun insertAllBooks(books: List<BookEntity>) = localDataSource.insertAllBooks(books)

    override suspend fun addBook(bookEntity: BookEntity) = localDataSource.addBook(bookEntity)

    override suspend fun updateBook(bookEntity: BookEntity) = localDataSource.updateBook(bookEntity)

    override suspend fun getBookById(bookId: Int): LiveData<BookEntity?> = localDataSource.getBookById(bookId)


}