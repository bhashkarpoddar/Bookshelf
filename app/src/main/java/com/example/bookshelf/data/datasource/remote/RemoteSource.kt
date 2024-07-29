package com.example.bookshelf.data.datasource.remote

import com.example.bookshelf.data.dto.books.BooksDTO
import com.example.bookshelf.domain.model.networkResult.NetworkResult


interface RemoteSource {
    suspend fun books(): NetworkResult<BooksDTO>
}