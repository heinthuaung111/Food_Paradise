package com.hta.food_paradise.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hta.food_paradise.Api.HeinThuAung.CategoriesApiClient
import com.hta.food_paradise.Model.Categories.CategoriesModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoriesViewModel:ViewModel() {
    private var result:MutableLiveData<CategoriesModel> = MutableLiveData()
    fun getResult():LiveData<CategoriesModel> =result
    
    fun loadResult(){
        var apiClient=CategoriesApiClient()
        val call=apiClient.getCategories()
        call.enqueue(object :Callback<CategoriesModel>{
            override fun onFailure(call: Call<CategoriesModel>, t: Throwable) {
                Log.d("error",t.toString())
            }

            override fun onResponse(
                call: Call<CategoriesModel>,
                response: Response<CategoriesModel>
            ) {
            result.value=response.body()!!
            }

        })
    }
}