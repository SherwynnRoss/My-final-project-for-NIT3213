package com.example.finalapp

//the response object returned by an authentication API endpoint after
// a login attempt. It contains the data that the server sends back
// to your application when a user attempts to log in.
data class LoginResponse(
    val keypass: String
)
