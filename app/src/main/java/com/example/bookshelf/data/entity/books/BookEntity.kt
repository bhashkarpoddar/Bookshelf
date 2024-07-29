package com.example.bookshelf.data.entity.books

import androidx.room.Entity

@Entity(tableName = "Books")
data class BookEntity(
    var id: String,
    val title: String,
    val description: String,
    val author: String,
    val year: String
)
