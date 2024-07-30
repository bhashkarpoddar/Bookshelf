package com.example.bookshelf.data.repository.books

import com.example.bookshelf.data.datasource.remote.RemoteSource
import com.example.bookshelf.data.dto.books.BooksDTO
import com.example.bookshelf.domain.model.networkResult.NetworkResult
import com.example.bookshelf.domain.repository.books.BookRepository
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(private val remoteSource: RemoteSource): BookRepository {
    override suspend fun books(): NetworkResult<BooksDTO> {

        /*return when (val localResult = local.getMovie(movieId)) {
            is Success -> localResult
            is Error -> remote.getMovie(movieId)
        }*/

        return remoteSource.books()
    }





}