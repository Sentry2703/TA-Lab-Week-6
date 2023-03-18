package com.driuft.Pets_Scroller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PetAdapter(private val petList: List<String>) : RecyclerView.Adapter<PetAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val petImage: ImageView

        init {
            petImage = view.findViewById(R.id.petImage)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pet_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = petList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.petImage.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Dog at position $position clicked", Toast.LENGTH_SHORT).show()
        }
       Glide.with(holder.itemView)
           .load(petList[position])
           .centerCrop()
           .into(holder.petImage)


    }


}

