package com.example.bookshelf.domain.usecase.addUpdateBook

import com.example.bookshelf.data.entity.books.BookEntity
import com.example.bookshelf.domain.model.networkResult.ResponseResult

interface AddUpdateBookUseCase {
    suspend operator fun invoke(bookEntity: BookEntity): ResponseResult<Long>
    suspend fun updateBook(bookEntity: BookEntity)
}