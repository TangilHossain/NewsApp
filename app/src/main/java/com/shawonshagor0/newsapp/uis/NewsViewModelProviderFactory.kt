package com.shawonshagor0.newsapp.uis

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shawonshagor0.newsapp.repositories.NewsRepository

class NewsViewModelProviderFactory(val app: Application, val newsRepository: NewsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(app, newsRepository) as T
    }
}