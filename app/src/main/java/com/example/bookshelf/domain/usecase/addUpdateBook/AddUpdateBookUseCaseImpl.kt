package com.example.bookshelf.domain.usecase.addUpdateBook

import com.example.bookshelf.data.entity.books.BookEntity
import com.example.bookshelf.domain.repository.books.BookRepository
import javax.inject.Inject

class AddUpdateBookUseCaseImpl @Inject constructor(private val bookRepository: BookRepository) :
    AddUpdateBookUseCase {

    override suspend fun invoke(bookEntity: BookEntity) {

    }

}