package com.shawonshagor0.newsapp.dbs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shawonshagor0.newsapp.models.Article


@Dao
interface ArticleDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long
    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>
    @Delete
    suspend fun deleteArticle(article: Article)
}