package com.example.bookshelf.domain.usecase.getBookDetails

import androidx.lifecycle.LiveData
import com.example.bookshelf.data.entity.books.BookEntity
import com.example.bookshelf.domain.model.books.Book

interface GetBookDetailsUseCase {
    suspend operator fun invoke(bookId: Int): LiveData<Book>

}