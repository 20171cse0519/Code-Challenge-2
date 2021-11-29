package com.example.codechallenge2.ui.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "articles"
)
data class ProductsResponseItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val category: String,
    val description: String,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)