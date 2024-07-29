package com.example.bookshelf.domain.usecase.books

import com.example.bookshelf.data.dto.books.BooksDTO
import com.example.bookshelf.data.dto.books.toDomain
import com.example.bookshelf.domain.model.books.Book
import com.example.bookshelf.domain.model.networkResult.NetworkResult
import com.example.bookshelf.domain.repository.books.BookRepository
import javax.inject.Inject


class BooksUseCaseImpl @Inject constructor(private val bookRepository: BookRepository) :
    BooksUseCase {

    override suspend fun invoke(): NetworkResult<List<Book>> {
        return when(val result = bookRepository.books()){
            is NetworkResult.Success -> NetworkResult.Success(result.data?.data?.map { it.toDomain() }, result.message!!)
            is NetworkResult.Failure -> NetworkResult.Failure(result.throwable, result.message ?: "Something went wrong!")
        }
    }

}