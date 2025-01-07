package com.shawonshagor0.newsapp.repositories

import com.shawonshagor0.newsapp.apis.RetrofitInstance
import com.shawonshagor0.newsapp.dbs.ArticleDatabase
import com.shawonshagor0.newsapp.models.Article

class NewsRepository(val db: ArticleDatabase) {
    suspend fun getHeadlines(countryCode: String, pageNumber: Int)=
        RetrofitInstance.api.getHeadlines(countryCode, pageNumber)


    suspend fun searchForNews(searchQuery: String, pageNumber: Int)=
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)
    fun getFavouriteNews() = db.getArticleDao().getAllArticles()
    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}