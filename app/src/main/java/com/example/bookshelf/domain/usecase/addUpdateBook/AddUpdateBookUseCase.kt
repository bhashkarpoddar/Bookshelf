package com.example.bookshelf.domain.usecase.addUpdateBook

import com.example.bookshelf.data.entity.books.BookEntity

interface AddUpdateBookUseCase {
    suspend operator fun invoke(bookEntity: BookEntity)
}