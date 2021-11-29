package com.example.codechallenge2.ui.api

import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{
        private val retrofit by lazy{
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
            Retrofit.Builder().baseUrl("https://fakestoreapi.com/products")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

        }
        val api by lazy {
            retrofit.create(ProductsAPI::class.java)
        }
    }
}