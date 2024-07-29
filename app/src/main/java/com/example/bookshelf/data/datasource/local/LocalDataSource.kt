package com.example.bookshelf.data.datasource.local

import androidx.lifecycle.LiveData
import com.example.bookshelf.data.entity.books.BookEntity

interface LocalDataSource {

    suspend fun books(): LiveData<List<BookEntity>>

}