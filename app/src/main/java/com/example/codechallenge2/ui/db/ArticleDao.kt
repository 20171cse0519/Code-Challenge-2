package com.example.codechallenge2.ui.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.codechallenge2.ui.models.ProductsResponseItem

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: ProductsResponseItem): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<ProductsResponseItem>>

    @Delete
    suspend fun deleteArticle(article: ProductsResponseItem)
}
