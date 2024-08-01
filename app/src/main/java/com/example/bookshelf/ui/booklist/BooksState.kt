package com.example.bookshelf.ui.booklist

import com.example.bookshelf.domain.model.books.Book

sealed class BooksState {
    object Loading: BooksState()
    object Empty: BooksState()
    data class Error(val errorMessage: String): BooksState()
    object NetworkRefresh: BooksState()
    data class Success(val books: List<Book>?): BooksState()
}