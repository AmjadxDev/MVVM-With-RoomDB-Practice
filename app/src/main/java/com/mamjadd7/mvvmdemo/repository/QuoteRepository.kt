package com.mamjadd7.mvvmdemo.repository

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import com.mamjadd7.mvvmdemo.database.QuoteDao
import com.mamjadd7.mvvmdemo.model.Quote

class QuoteRepository(val quoteDao : QuoteDao) {

    @Query("SELECT * FROM quote")
    fun getQuote() : LiveData<List<Quote>>{
        return quoteDao.getQuote()
    }

    @Insert
    suspend fun insetQuote(quote: Quote) {
        return quoteDao.insertQuote(quote)
    }
}