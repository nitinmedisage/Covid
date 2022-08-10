package com.elink.covidassingment.services

import com.elink.covidassingment.model.APIResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST




/**
 * Created by Nitin Sabale
 * @since 27-07-2022. 18:21
 */
interface ApiService {

    @GET("regions")
    fun getUsers(): Call<APIResponse>
}