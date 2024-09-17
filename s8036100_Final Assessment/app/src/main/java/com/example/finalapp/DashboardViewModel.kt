package com.example.finalapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalapp.Entity
import com.example.finalapp.RetrofitInstance
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {
    // LiveData to hold the list of entities retrieved from the API
    val entities = MutableLiveData<List<Entity>>()


    // Function to load dashboard data from the API
    fun loadDashboardData(keypass: String) {
        // Launch a coroutine in the ViewModel's scope for performing the network operation
        viewModelScope.launch {
            try {
                //Make a network request to get the dashboard data using Retrofit
                val response = RetrofitInstance.api.getDashboardData(keypass)
                // Check if the response is successful
                if (response.isSuccessful) {
                    // If successful, post the list of entities to the LiveData
                    // 'response.body()?.entities' extracts the list of entities
                    // from the response body
                    entities.postValue(response.body()?.entities)
                } else {
                    // Handle unsuccessful response (e.g., show error message)
                }
            } catch (e: Exception) {
                // Handle exceptions (e.g., network errors)
            }
        }
    }
}
