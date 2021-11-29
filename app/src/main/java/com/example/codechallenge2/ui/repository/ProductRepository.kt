package com.example.codechallenge2.ui.repository

import com.example.codechallenge2.ui.api.RetrofitInstance
import com.example.codechallenge2.ui.db.ArticleDatabase

class ProductRepository(
    val db:ArticleDatabase
) {

    suspend fun getMainProducts(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getProducts(countryCode,pageNumber)
}