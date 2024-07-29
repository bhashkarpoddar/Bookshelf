package com.example.bookshelf.domain.repository.books

import com.example.bookshelf.data.dto.books.BooksDTO
import com.example.bookshelf.domain.model.networkResult.NetworkResult

interface BookRepository {
    suspend fun books(): NetworkResult<BooksDTO>
}