package com.hta.food_paradise.Api.HeinThuAung

import com.hta.food_paradise.Model.Categories.CategoriesModel
import com.hta.food_paradise.Model.Random
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RandomApiClient {
    private val BASE_URL="https://www.themealdb.com/api/json/v1/1/"


    private val apiInterface:RandomApiInterface

    init {
        val retrofit=
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        apiInterface=retrofit.create(RandomApiInterface::class.java)
    }

    fun getRandom(): Call<Random> {
        return apiInterface.getRandom()
    }
}