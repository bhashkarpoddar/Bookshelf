package com.example.bookshelf.domain.model.books

data class Book(
    val id: String,
    val title: String,
    val description: List<String>,
    val publisher: String,
    val author: String,
    val year: String
)
