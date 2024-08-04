package com.example.bookshelf.data.datasource.local

import androidx.lifecycle.LiveData
import com.example.bookshelf.data.entity.books.BookEntity
import com.example.bookshelf.domain.model.networkResult.ResponseResult
import com.example.bookshelf.utils.safeCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val booksDao: BooksDao) : LocalDataSource {
    override suspend fun books(): LiveData<List<BookEntity>> = booksDao.books()

    override suspend fun insertAllBooks(books: List<BookEntity>) = booksDao.insertAllBooks(books)

    override suspend fun addBook(bookEntity: BookEntity): ResponseResult<Long> {
        return withContext(Dispatchers.IO) {
            safeCall {
                val id = booksDao.insertBook(bookEntity)
                ResponseResult.Success(id, "Success")
            }
        }
    }

    override suspend fun updateBook(bookEntity: BookEntity) = booksDao.updateBook(bookEntity)

    override suspend fun getBookById(bookId: Int) = booksDao.getBookById(bookId)

}