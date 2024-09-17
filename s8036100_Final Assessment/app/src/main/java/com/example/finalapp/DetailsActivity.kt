package com.example.finalapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {


    // Called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the content view to the layout file activity_details.xml
        setContentView(R.layout.activity_details)


        // Retrieve data passed via the Intent from the previous activity
        val careLevel = intent.getStringExtra("careLevel")
        val commonName= intent.getStringExtra("commonName")
        val lightRequirement = intent.getStringExtra("lightRequirement")
        val scientificName = intent.getStringExtra("scientificName")
        val description = intent.getStringExtra("description")

        // Find TextView components from the layout and set their text to
        // the corresponding data
        findViewById<TextView>(R.id.careLevel).text = careLevel
        findViewById<TextView>(R.id.commonName).text = commonName
        findViewById<TextView>(R.id.lightRequirement).text = lightRequirement
        findViewById<TextView>(R.id.scientificName).text = scientificName
        findViewById<TextView>(R.id.descriptionTextView).text = description
    }
}
