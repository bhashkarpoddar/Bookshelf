package com.example.bookshelf.ui.booklist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookshelf.domain.model.networkResult.ResponseResult
import com.example.bookshelf.domain.usecase.books.BooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
                    is ResponseResult.Failure -> _booksState.postValue(BooksState.Error(books.message!!))
                    is ResponseResult.Success -> {
                        _booksState.postValue(BooksState.NetworkRefresh)
                    }
                }
            }
        }
    }

}