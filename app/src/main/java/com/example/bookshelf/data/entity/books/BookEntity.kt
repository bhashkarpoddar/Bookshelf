package com.example.bookshelf.data.entity.books

import androidx.room.Entity
import com.example.bookshelf.data.dto.books.toDomain
import com.example.bookshelf.domain.model.books.Book

@Entity(tableName = "Books")
data class BookEntity(
    var id: Int,
    val title: String,
    val description: List<String>,
    val publisher: String,
    val author: String,
    val year: String
)

fun BookEntity.toBook() = Book(
    id = this.id,
    title = this.title.orEmpty(),
    description = this.description.orEmpty(),
    publisher = this.publisher.orEmpty(),
    author = this.author.orEmpty(),
    year = this.year.toString()
)