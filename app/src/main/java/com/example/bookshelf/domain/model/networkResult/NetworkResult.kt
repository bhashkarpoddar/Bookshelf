package com.example.bookshelf.domain.model.networkResult

/**
 * A wrapper for handling failing requests
 * */
sealed class NetworkResult<T>(val data: T? = null, val message: String? = null, val throwable: Throwable? = null) {
    class Success<T>(data: T? = null, message: String) : NetworkResult<T>(data, message)
    class Failure<T>(throwable: Throwable? = null, message: String) : NetworkResult<T>(null, message, throwable)
}