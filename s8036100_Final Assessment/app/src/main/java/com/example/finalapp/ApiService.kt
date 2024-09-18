package com.example.finalapp

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

// Retrofit API interface
// This interface defines the API endpoints that will be used 
//to interact with the backend server.
// Retrofit uses these interface methods to make network calls.
interface ApiService {


    // The function takes in a LoginRequest object (credentials) as the body of the POST request.
    // It suspends the coroutine while making the network request, so it must be called 
    //from a coroutine or another suspend function.
    // The function returns a Response object wrapping the LoginResponse type, which 
    //contains the server's response to the login attempt.
    @POST("footscray/auth") // This specifies the relative URL path to the login endpoint.
    suspend fun login(@Body credentials: LoginRequest): Response<LoginResponse>



    // GET request to fetch dashboard data
    // This function sends a GET request to retrieve data, such as plant information for a dashboard.
    // The request requires a dynamic segment in the URL (referred to as `keypass` in the path), which is 
    //provided as a parameter in the function.
    // Like the login function, it suspends the coroutine during the network call and returns a 
    //Response object wrapping the DashboardResponse type.
    @GET("dashboard/plants") // The curly braces in the URL signify that `keypass` is a path parameter.
    suspend fun getDashboardData(@Path("keypass") keypass: String): Response<DashboardResponse>
}
