package com.example.bookshelf.data.datasource.remote

import com.example.bookshelf.data.dto.books.BooksDTO
import retrofit2.http.GET

interface ApiServices {

    @GET("books")
    suspend fun books(): BooksDTO


}