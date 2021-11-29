package com.example.codechallenge2.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codechallenge2.R
import com.example.codechallenge2.ui.ProductViewModel
import com.example.codechallenge2.ui.ProductsActivity
import com.example.codechallenge2.ui.adapters.ProductsAdapter
import com.example.codechallenge2.ui.models.ProductsResponse
import com.example.codechallenge2.ui.models.ProductsResponseItem
import com.example.codechallenge2.ui.util.Resource
import kotlinx.android.synthetic.main.fragment_main_products.*

class MainProductsFragment : Fragment(R.layout.fragment_main_products) {

    lateinit var viewModel : ProductViewModel
    lateinit var productsAdapter : ProductsAdapter

    val TAG = "MainProductsFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as ProductsActivity).viewModel
        setUpRecyclerView()

        viewModel.mainProducts.observe(viewLifecycleOwner, Observer{response ->
            when(response){
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { productsResponse ->
                        productsAdapter.differ.submitList(productsResponse)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e(TAG,"error occurred: $message")
                    }
                }

                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }

    private fun hideProgressBar(){
        paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar(){
        paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setUpRecyclerView(){
        productsAdapter = ProductsAdapter()
        rvMainProducts.apply {
            adapter = productsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}