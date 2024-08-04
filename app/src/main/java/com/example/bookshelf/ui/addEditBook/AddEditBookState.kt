package com.example.bookshelf.ui.addEditBook

import com.example.bookshelf.domain.model.books.Book

sealed class AddEditBookState {
    object Loading: AddEditBookState()
    object Empty: AddEditBookState()
    data class Error(val errorMessage: String): AddEditBookState()
    data class AddBookSuccess(val bookId: Long): AddEditBookState()
    data class EditBookSuccess(val book: Book): AddEditBookState()

    data class GetBookDetailsSuccess(val book: Book): AddEditBookState()
}