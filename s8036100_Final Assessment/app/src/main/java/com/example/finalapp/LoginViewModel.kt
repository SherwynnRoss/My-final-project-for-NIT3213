package com.example.finalapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.finalapp.LoginRequest
import com.example.finalapp.LoginResponse


class LoginViewModel : ViewModel() {
    // LiveData to hold the result of a successful login operation
    val loginSuccess = MutableLiveData<String>()
    // LiveData to indicate whether there was an error during login
    val loginError = MutableLiveData<Boolean>()


    // Function to handle user login
    fun login(username: String, password: String) {
        // Create a LoginRequest object with the provided username and password
        val loginRequest = LoginRequest(username, password)


        // Launch a coroutine in the ViewModel's scope for performing the network operation
        viewModelScope.launch {
            try {
                // Make a network request to the login API using Retrofit
                val response = RetrofitInstance.api.login(loginRequest)
                // Check if the response is successful and the response body is not null
                if (response.isSuccessful && response.body() != null) {
                    // Extract the keypass from the response body and post it
                    // to loginSuccess LiveData
                    loginSuccess.postValue(response.body()?.keypass)
                } else {
                    // If the response is not successful or the response body is null,
                    // it will post an error
                    loginError.postValue(true)
                }
            } catch (e: Exception) {
                // If an exception happens(e.g., network error), then it will post an error
                loginError.postValue(true)
            }
        }
    }
}
