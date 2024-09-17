package com.example.finalapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

object RetrofitInstance {
    // Base URL for the API endpoints
    private const val BASE_URL = "https://vu-nit3213-api.onrender.com/"


    // Lazy initialization of the Retrofit instance and ApiService interface
    val api: ApiService by lazy {
        Retrofit.Builder()// Build a new Retrofit instance
            .baseUrl(BASE_URL)// Set the base URL for the API requests
            .addConverterFactory(GsonConverterFactory.create())// Add a converter to parse JSON responses
            .build()// Build the Retrofit instance
            .create(ApiService::class.java)// Create an implementation of the ApiService interface
    }
}


