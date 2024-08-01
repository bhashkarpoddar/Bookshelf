package com.example.bookshelf.data.dto.books

import com.example.bookshelf.data.entity.books.BookEntity
import com.example.bookshelf.domain.model.books.Book

data class BookDTO(
    val ISBN: String,
    val Notes: List<String>,
    val Pages: Int,
    val Publisher: String,
    val Title: String,
    val Year: Int,
    val created_at: String,
    val handle: String,
    val id: Int,
    val author: String = "Stephen King",
    val villains: List<Villain>
)

fun BookDTO.toDomain() = Book(
    id = this.id,
    title = this.Title.orEmpty(),
    description = this.Notes.joinToString(),
    publisher = this.Publisher.orEmpty(),
    author = this.author.orEmpty(),
    year = this.Year.toString()
)

fun BookDTO.toEntity() = BookEntity(
    id = this.id,
    title = this.Title.orEmpty(),
    description = this.Notes.joinToString(),
    publisher = this.Publisher.orEmpty(),
    author = "Stephen King",
    year = this.Year.toString()
)