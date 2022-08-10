package com.elink.covidassingment.network

/**
 * Created by Nitin Sabale
 * @since 27-07-2022. 18:22
 */
import com.elink.covidassingment.services.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {

    private const val BASE_URL: String = "https://covid-19-statistics.p.rapidapi.com/"
    private val gson : Gson by lazy {
        GsonBuilder().setLenient().create()
    }


    private val okHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(
                Interceptor { chain ->
                    val builder = chain.request().newBuilder()
                    builder.header("X-RapidAPI-Key", "22376b57cdmsh1964956a19901eep10de21jsne982fc3fd17f")
                    builder.header("X-RapidAPI-Host", "covid-19-statistics.p.rapidapi.com")
                    return@Interceptor chain.proceed(builder.build())
                }
        )
    }.build()


    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val apiService : ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }

}