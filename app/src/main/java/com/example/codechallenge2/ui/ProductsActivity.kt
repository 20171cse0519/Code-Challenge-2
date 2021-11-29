package com.example.codechallenge2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.codechallenge2.R
import com.example.codechallenge2.ui.db.ArticleDatabase
import com.example.codechallenge2.ui.repository.ProductRepository
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var viewModel: ProductViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val productRepository = ProductRepository(ArticleDatabase(this))
        val viewModelProviderFactory = ProductViewModelProviderFactory(productRepository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(ProductViewModel::class.java)

        bottomNavigationView.setupWithNavController(productsNavHostFragment.findNavController())
    }
}