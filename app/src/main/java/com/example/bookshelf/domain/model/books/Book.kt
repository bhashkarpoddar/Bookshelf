package com.example.bookshelf.domain.model.books

import com.example.bookshelf.data.entity.books.BookEntity

data class Book(
    val id: Int = 0,
    val title: String,
    val description: String,
    val publisher: String,
    val author: String,
    val year: String
)


fun Book.toBookEntity() = BookEntity(
    id = this.id,
    title = this.title.orEmpty(),
    description = this.description,
    publisher = this.publisher.orEmpty(),
    author = this.author.orEmpty(),
    year = this.year.toString()
)