package com.hta.food_paradise.Api.HeinThuAung

import com.hta.food_paradise.Model.Categories.CategoriesModel
import retrofit2.Call
import retrofit2.http.GET

interface CategoriesApiInterface {
@GET("categories.php")
fun getCategories():Call<CategoriesModel>
}