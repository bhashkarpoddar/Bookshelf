package com.example.bookshelf.domain.usecase.books

import com.example.bookshelf.domain.model.books.Book
import com.example.bookshelf.domain.model.networkResult.NetworkResult

interface BooksUseCase {
    suspend operator fun invoke(): NetworkResult<List<Book>>

}