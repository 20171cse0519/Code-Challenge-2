package com.example.codechallenge2.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.codechallenge2.ui.repository.ProductRepository

class ProductViewModelProviderFactory(
    val productRepository: ProductRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(productRepository) as T
    }
}