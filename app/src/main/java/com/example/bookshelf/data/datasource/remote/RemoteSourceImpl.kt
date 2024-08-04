package com.example.bookshelf.data.datasource.remote

import com.example.bookshelf.data.dto.books.BooksDTO
import com.example.bookshelf.domain.model.networkResult.ResponseResult
import com.example.bookshelf.utils.safeCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteSourceImpl @Inject constructor(private val apiService: ApiServices) : RemoteSource {
    override suspend fun books(): ResponseResult<BooksDTO> {
        return withContext(Dispatchers.IO) {
            safeCall {
                val data = apiService.books()
                ResponseResult.Success(data, "Success")
            }
        }
    }

}