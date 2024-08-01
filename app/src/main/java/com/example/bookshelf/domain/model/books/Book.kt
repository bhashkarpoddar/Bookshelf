package com.example.bookshelf.domain.model.books

data class Book(
    val id: Int,
    val title: String,
    val description: String,
    val publisher: String,
    val author: String,
    val year: String
)
