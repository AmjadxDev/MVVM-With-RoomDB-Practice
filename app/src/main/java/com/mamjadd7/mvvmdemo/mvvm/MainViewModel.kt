package com.mamjadd7.mvvmdemo.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mamjadd7.mvvmdemo.model.Quote
import com.mamjadd7.mvvmdemo.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val quoteRepository : QuoteRepository) : ViewModel() {
    fun getQuote() : LiveData<List<Quote>> {
        return quoteRepository.getQuote()
    }

    fun insertQuote(quote: Quote) {

        viewModelScope.launch(Dispatchers.IO){
            quoteRepository.insetQuote(quote)
        }
    }
}