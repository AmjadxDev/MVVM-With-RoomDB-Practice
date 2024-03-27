package com.mamjadd7.mvvmdemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mamjadd7.mvvmdemo.model.Quote

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase : RoomDatabase(){
    abstract fun quoteDao() : QuoteDao

    companion object{
        @Volatile
        private var INSTANCE : QuoteDatabase? = null

        fun getDatabase(context : Context) : QuoteDatabase {
            synchronized(this){
                INSTANCE = Room.databaseBuilder(context,
                    QuoteDatabase::class.java, "quote_database")
                    .createFromAsset("quotes.db")
                    .build()
            }
            return INSTANCE!!
        }

    }
}