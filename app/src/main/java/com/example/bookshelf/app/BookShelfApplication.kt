package com.example.bookshelf.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BookShelfApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}