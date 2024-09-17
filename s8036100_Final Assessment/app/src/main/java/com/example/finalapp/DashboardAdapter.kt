package com.example.finalapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalapp.Entity


//Displays a list of entities in a RecyclerView
class DashboardAdapter(private val entityList: List<Entity>) :
    RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {


    // ViewHolder class to hold the views for each item in the RecyclerView
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val careLevel: TextView = view.findViewById(R.id.careLevel)
        val commonName: TextView = view.findViewById(R.id.commonName)
        val lightRequirement: TextView = view.findViewById(R.id.lightRequirement)
        val scientificName: TextView = view.findViewById(R.id.scientificName)

    }


    // Create new ViewHolder instances for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.entity_item, parent, false)
        return ViewHolder(view)
    }


    // Bind data to the views in the ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the current entity from the list
        val entity = entityList[position]
        // Set the TextViews with the data from the entity
        holder.careLevel.text = entity.careLevel
        holder.commonName.text = entity.commonName
        holder.lightRequirement.text = entity.lightRequirement
        holder.scientificName.text = entity.scientificName




        // Navigate to Details Screen
        holder.itemView.setOnClickListener {
            // Create an Intent to start the DetailsActivity
            val intent = Intent(holder.itemView.context, DetailsActivity::class.java)

            // Pass the entity's details to the DetailsActivity via Intent extras
            intent.putExtra("careLevel", entity.careLevel)
            intent.putExtra("commonName", entity.commonName)
            intent.putExtra("lightRequirement", entity.lightRequirement)
            intent.putExtra("scientificName", entity.scientificName)
            intent.putExtra("description", entity.description)
            // Start the DetailsActivity
            holder.itemView.context.startActivity(intent)
        }
    }
    // Return the total number of items in the list
    override fun getItemCount() = entityList.size
}
