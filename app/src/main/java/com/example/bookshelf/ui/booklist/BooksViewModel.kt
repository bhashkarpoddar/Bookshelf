package com.example.bookshelf.ui.booklist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.bookshelf.domain.model.books.Book
import com.example.bookshelf.domain.model.networkResult.NetworkResult
import com.example.bookshelf.domain.usecase.books.BooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(private val booksUseCase: BooksUseCase) : ViewModel() {

    private val _booksState = MutableLiveData<BooksState>()
    val bookState: LiveData<BooksState> = _booksState

    init {
        getBooks()
    }

    fun getBooks() {
        _booksState.postValue(BooksState.Loading)

        viewModelScope.launch(Dispatchers.Main) {
            booksUseCase().observeForever {
                Log.d("TAG", "getBooks: $it")
                _booksState.postValue(BooksState.Success(it))
            }
        }
    }

    fun refreshBook() {
        _booksState.postValue(BooksState.Loading)

        viewModelScope.launch(Dispatchers.Main) {
            booksUseCase.refreshBook().let { books ->
                when (books) {
                    is NetworkResult.Failure -> _booksState.postValue(BooksState.Error(books.message!!))
                    is NetworkResult.Success -> {
                        _booksState.postValue(BooksState.NetworkRefresh)
                    }
                }
            }
        }
    }

}