package com.example.bookshelf.domain.usecase.books

import androidx.lifecycle.LiveData
import com.example.bookshelf.data.dto.books.BooksDTO
import com.example.bookshelf.domain.model.books.Book
import com.example.bookshelf.domain.model.networkResult.ResponseResult

interface BooksUseCase {
    suspend operator fun invoke(): LiveData<List<Book>>

    suspend fun refreshBook(): ResponseResult<BooksDTO>

}