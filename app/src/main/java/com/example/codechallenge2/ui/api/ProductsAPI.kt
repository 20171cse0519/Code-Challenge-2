package com.example.codechallenge2.ui.api

import com.example.codechallenge2.ui.models.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductsAPI {

    @GET("products")
    suspend fun getProducts(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber: Int = 1,


    ): Response<ProductsResponse>

    @GET("products")
    suspend fun searchProducts(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,


        ): Response<ProductsResponse>
}