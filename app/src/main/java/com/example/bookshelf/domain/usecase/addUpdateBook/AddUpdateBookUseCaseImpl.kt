package com.example.bookshelf.domain.usecase.addUpdateBook

import android.util.Log
import androidx.lifecycle.map
import com.example.bookshelf.data.dto.books.toEntity
import com.example.bookshelf.data.entity.books.BookEntity
import com.example.bookshelf.data.entity.books.toBook
import com.example.bookshelf.domain.model.books.Book
import com.example.bookshelf.domain.model.networkResult.ResponseResult
import com.example.bookshelf.domain.repository.books.BookRepository
import javax.inject.Inject

class AddUpdateBookUseCaseImpl @Inject constructor(private val bookRepository: BookRepository) :
    AddUpdateBookUseCase {

    override suspend fun invoke(bookEntity: BookEntity): ResponseResult<Long> = bookRepository.addBook(bookEntity)

    override suspend fun updateBook(bookEntity: BookEntity) = bookRepository.updateBook(bookEntity)

}