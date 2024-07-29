package com.example.bookshelf.data.datasource.local

import androidx.lifecycle.LiveData
import com.example.bookshelf.data.datasource.remote.ApiServices
import com.example.bookshelf.data.entity.books.BookEntity
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val apiService: ApiServices) : LocalDataSource {
    override suspend fun books(): LiveData<List<BookEntity>> {

    }

}