package com.hta.food_paradise.Api.HeinThuAung

import com.hta.food_paradise.Model.Categories.CategoriesModel
import com.hta.food_paradise.Model.Random
import retrofit2.Call
import retrofit2.http.GET

interface RandomApiInterface {
    @GET("random.php")
    fun getRandom(): Call<Random>
}