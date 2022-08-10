package com.elink.repository

/**
 * Created by Nitin Sabale
 * @since 27-07-2022. 18:27
 */
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.elink.covidassingment.model.APIResponse
import com.elink.covidassingment.model.DataList
import com.elink.covidassingment.network.ApiClient


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class UserRepository {


    fun getMutableLiveData() : MutableLiveData<ArrayList<DataList>>{
        val mutableLiveData = MutableLiveData<ArrayList<DataList>>()
        ApiClient.apiService.getUsers().enqueue(object : Callback<APIResponse> {
            override fun onFailure(call: Call<APIResponse>, t: Throwable) {
                Log.e("error", t.localizedMessage)
            }
            override fun onResponse(
                call: Call<APIResponse>,
                response: Response<APIResponse>
            ) {
                val usersResponse = response.body()!!.data
                usersResponse?.let { mutableLiveData.value = it as ArrayList<DataList> }
            }
        })
        return mutableLiveData
    }

}