package com.mamjadd7.mvvmdemo.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mamjadd7.mvvmdemo.model.Quote

@Dao
interface QuoteDao {

    @Query("SELECT * FROM quote")
    fun getQuote() : LiveData<List<Quote>>

    @Insert
    suspend fun insertQuote(quote: Quote)
}