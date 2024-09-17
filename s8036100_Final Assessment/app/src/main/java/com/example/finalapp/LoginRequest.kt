package com.example.finalapp


//To sum up the data that you send to the server when making a login request.
//Shows the structure of the request payload that the server expects to
// receive for authentication.
data class LoginRequest(
    val username: String,
    val password: String
)
