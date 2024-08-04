package com.example.bookshelf.domain.usecase.books

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.bookshelf.data.dto.books.BooksDTO
import com.example.bookshelf.data.dto.books.toEntity
import com.example.bookshelf.data.entity.books.toBook
import com.example.bookshelf.domain.model.books.Book
import com.example.bookshelf.domain.model.networkResult.ResponseResult
import com.example.bookshelf.domain.repository.books.BookRepository
import javax.inject.Inject


class BooksUseCaseImpl @Inject constructor(private val bookRepository: BookRepository) :
    BooksUseCase {
    override suspend fun invoke(): LiveData<List<Book>> = bookRepository.books().map { it.map { it.toBook() } }

    override suspend fun refreshBook(): ResponseResult<BooksDTO> {
        return when(val result = bookRepository.refreshBooks()){
            is ResponseResult.Success -> {
                result.data?.let {booksDTO ->
                    Log.d("TAG", "refreshBook: ${booksDTO.data[0]}")
                    val books = booksDTO.data.map { it.toEntity() }
                    try {
                        bookRepository.insertAllBooks(books)
                    } catch (ex: Exception){
                        ex.printStackTrace()
                    }
                }
                ResponseResult.Success(result.data, result.message!!)
            }
            is ResponseResult.Failure -> {
                /*Something went wrong*/
                /*Handle Error with gracefully*/
                ResponseResult.Failure(null, result.message!!)
            }
        }
    }


}