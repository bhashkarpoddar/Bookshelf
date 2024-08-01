package com.example.bookshelf.data.entity.books

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.bookshelf.data.dto.books.toDomain
import com.example.bookshelf.domain.model.books.Book

@Entity(tableName = "Books")
data class BookEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Int = 0,
    val title: String,
    val description: String,
    val publisher: String,
    val author: String,
    val year: String
)

fun BookEntity.toBook() = Book(
    id = this.id,
    title = this.title.orEmpty(),
    description = this.description,
    publisher = this.publisher.orEmpty(),
    author = this.author.orEmpty(),
    year = this.year.toString()
)