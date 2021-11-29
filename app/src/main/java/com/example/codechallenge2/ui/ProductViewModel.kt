package com.example.codechallenge2.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codechallenge2.ui.models.ProductsResponse
import com.example.codechallenge2.ui.repository.ProductRepository
import com.example.codechallenge2.ui.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class ProductViewModel(
    val productRepository: ProductRepository
):ViewModel() {

    val mainProducts: MutableLiveData<Resource<ProductsResponse>> = MutableLiveData()
    var mainProductsPage = 1

    init {
        getMainProducts(countryCode = "us")
    }

    fun getMainProducts(countryCode: String) = viewModelScope.launch {
        mainProducts.postValue(Resource.Loading())
        val response = productRepository.getMainProducts(countryCode, mainProductsPage)
        mainProducts.postValue(handleMainProductsResponse((response)))
    }

    private fun handleMainProductsResponse(response: Response<ProductsResponse>): Resource<ProductsResponse>{
        if(response.isSuccessful){
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}