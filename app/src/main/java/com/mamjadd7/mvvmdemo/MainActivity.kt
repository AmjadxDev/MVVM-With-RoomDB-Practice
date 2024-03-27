package com.mamjadd7.mvvmdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mamjadd7.mvvmdemo.database.QuoteDao
import com.mamjadd7.mvvmdemo.database.QuoteDatabase
import com.mamjadd7.mvvmdemo.databinding.ActivityMainBinding
import com.mamjadd7.mvvmdemo.model.Quote
import com.mamjadd7.mvvmdemo.mvvm.MainViewModalFactory
import com.mamjadd7.mvvmdemo.mvvm.MainViewModel
import com.mamjadd7.mvvmdemo.repository.QuoteRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private lateinit var repository: QuoteRepository
    private lateinit var mainViewModel: MainViewModel
    private lateinit var dao : QuoteDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil
            .setContentView(this, R.layout.activity_main)

        dao = QuoteDatabase.getDatabase(applicationContext).quoteDao()
        repository = QuoteRepository(dao)

        mainViewModel = ViewModelProvider(this,
            MainViewModalFactory(repository))[MainViewModel::class.java]

        mainViewModel.getQuote().observe(this, Observer {
            binding.quotesss = it.toString()
        })

        binding.btnInsertQuote.setOnClickListener {
            val quote = Quote(0, "this is first quote", "james")
            mainViewModel.insertQuote(quote)
        }






    }
}