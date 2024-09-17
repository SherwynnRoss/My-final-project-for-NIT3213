package com.example.finalapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalapp.Entity

class DashboardActivity : AppCompatActivity() {


    // Explicitly specify the type parameter
    // `DashboardViewModel` is responsible for holding and
    // managing UI-related data in a lifecycle-conscious way.
    private val dashboardViewModel by viewModels<DashboardViewModel>()


    // This method is called when the activity is starting.
    // `onCreate` is where most initialization occurs.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the layout of the activity to `activity_dashboard.xml`.
        setContentView(R.layout.activity_dashboard)


        // Retrieve the string extra named "keypass"
        // from the intent that started this activity.
        // If no value was passed, `return` is used
        // to exit the method to prevent further execution.
        val keypass = intent.getStringExtra("keypass") ?: return


        // Find the RecyclerView component in the layout by its ID and set
        // its layout manager.
        // `LinearLayoutManager` organizes the items in a linear vertical list.
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        // Call a method on the ViewModel to load data related to the keypass.
        // This might be data fetched from a database, network, or other sources.
        dashboardViewModel.loadDashboardData(keypass)


        // Observe the LiveData `entities` in the ViewModel.
        // When `entities` is updated, the `observer` lambda
        // (function) will be triggered.
        // The `DashboardAdapter` is then used to provide the data to the `RecyclerView`.
        dashboardViewModel.entities.observe(this) { entities ->
            recyclerView.adapter = DashboardAdapter(entities)
        }
    }
}
