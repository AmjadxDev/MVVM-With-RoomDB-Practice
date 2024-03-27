package com.mamjadd7.mvvmdemo.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mamjadd7.mvvmdemo.repository.QuoteRepository

class MainViewModalFactory(private val quoteRepository: QuoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(quoteRepository) as T
    }
}