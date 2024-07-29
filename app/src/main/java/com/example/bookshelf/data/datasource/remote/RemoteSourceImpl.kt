package com.example.bookshelf.data.datasource.remote

import com.example.bookshelf.data.dto.books.BooksDTO
import com.example.bookshelf.domain.model.networkResult.NetworkResult
import com.example.bookshelf.utils.safeNetworkCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteSourceImpl @Inject constructor(private val apiService: ApiServices) : RemoteSource {
    override suspend fun books(): NetworkResult<BooksDTO> {
        return withContext(Dispatchers.IO) {
            safeNetworkCall {
                val data = apiService.books()
                NetworkResult.Success(data, "Success")
            }
        }
    }

}