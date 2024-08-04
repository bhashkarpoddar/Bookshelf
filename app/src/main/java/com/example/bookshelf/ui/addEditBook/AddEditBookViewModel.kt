package com.example.bookshelf.ui.addEditBook

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookshelf.domain.model.books.Book
import com.example.bookshelf.domain.model.books.toBookEntity
import com.example.bookshelf.domain.model.networkResult.ResponseResult
import com.example.bookshelf.domain.usecase.addUpdateBook.AddUpdateBookUseCase
import com.example.bookshelf.domain.usecase.books.BooksUseCase
import com.example.bookshelf.domain.usecase.getBookDetails.GetBookDetailsUseCase
import com.example.bookshelf.ui.booklist.BooksState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditBookViewModel @Inject constructor(private val addUpdateBookUseCase: AddUpdateBookUseCase, private val getBookDetailsUseCase: GetBookDetailsUseCase) : ViewModel() {

    private val _booksState = MutableLiveData<AddEditBookState>()
    val bookState: LiveData<AddEditBookState> = _booksState

    init {

    }

    fun addBook(book: Book) {
        _booksState.postValue(AddEditBookState.Loading)

        viewModelScope.launch(Dispatchers.Main) {
            addUpdateBookUseCase(book.toBookEntity()).let{
                when(it) {
                    is ResponseResult.Success -> {
                        _booksState.postValue(AddEditBookState.AddBookSuccess(it.data!!))
                    }
                    is ResponseResult.Failure -> {
                        _booksState.postValue(AddEditBookState.Error(it.message!!))
                    }
                }

            }
        }
    }

    fun getBooksById(id: Int){
        _booksState.postValue(AddEditBookState.Loading)

        viewModelScope.launch(Dispatchers.Main) {
            getBookDetailsUseCase(id).observeForever {
                _booksState.postValue(AddEditBookState.GetBookDetailsSuccess(it))
            }
        }
    }

    fun updateBook(book: Book) {
        /*_booksState.postValue(AddEditBookState.Loading)

        viewModelScope.launch(Dispatchers.Main) {
            addUpdateBookUseCase.updateBook(book.toBookEntity()).let {
                Log.d("TAG", "getBooks: $it")
                _booksState.postValue(AddEditBookState.EditBookSuccess(it))
            }
        }*/
    }

    override fun onCleared() {
        super.onCleared()
    }

}