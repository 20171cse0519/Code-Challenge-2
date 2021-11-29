package com.example.codechallenge2.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.codechallenge2.R
import com.example.codechallenge2.ui.ProductViewModel
import com.example.codechallenge2.ui.ProductsActivity

class SearchProductsFragment : Fragment(R.layout.fragment_search_products) {

    lateinit var viewModel : ProductViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as ProductsActivity).viewModel
    }
}