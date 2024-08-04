package com.example.bookshelf.domain.usecase.getBookDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.bookshelf.data.entity.books.toBook
import com.example.bookshelf.domain.model.books.Book
import com.example.bookshelf.domain.repository.books.BookRepository
import javax.inject.Inject

class GetBookDetailsUseCaseImpl@Inject constructor(private val bookRepository: BookRepository) : GetBookDetailsUseCase {
    override suspend fun invoke(bookId: Int): LiveData<Book> = bookRepository.getBookById(bookId).map { it!!.toBook() }

}