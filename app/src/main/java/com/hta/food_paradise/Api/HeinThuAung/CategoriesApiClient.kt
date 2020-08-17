package com.hta.food_paradise.Api.HeinThuAung

import com.hta.food_paradise.Model.Categories.CategoriesModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CategoriesApiClient {
    private val BASE_URL="https://www.themealdb.com/api/json/v1/1/"


    private val apiInterface:CategoriesApiInterface

    init {
        val retrofit=Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        apiInterface=retrofit.create(CategoriesApiInterface::class.java)
    }

    fun getCategories():Call<CategoriesModel>{
        return apiInterface.getCategories()
    }
}