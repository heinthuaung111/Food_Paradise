package com.hta.food_paradise.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hta.food_paradise.Api.HeinThuAung.RandomApiClient
import com.hta.food_paradise.Model.Random
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RandomViewModel:ViewModel() {

    private var result:MutableLiveData<Random> = MutableLiveData()
    fun getResult():LiveData<Random> =result

    fun loadResult(){
        var apiClient=RandomApiClient()
        val call=apiClient.getRandom()
        call.enqueue(object :Callback<Random>{
            override fun onFailure(call: Call<Random>, t: Throwable) {
                Log.d("error",t.toString())

            }

            override fun onResponse(call: Call<Random>, response: Response<Random>) {
                result.value=response.body()!!
            }
        })
    }

}



