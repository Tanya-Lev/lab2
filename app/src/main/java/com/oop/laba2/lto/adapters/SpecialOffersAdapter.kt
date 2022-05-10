package com.oop.laba2.lto.adapters

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView
import com.oop.laba2.lto.R
import com.oop.laba2.lto.Utils
import com.oop.laba2.lto.Utils.dp
import com.oop.laba2.lto.Utils.px
import com.oop.laba2.lto.enteties.House
import kotlin.random.Random

class SpecialOffersAdapter(val houses:List<House>):RecyclerView.Adapter<SpecialOffersAdapter.SpecialOffersViewHolder>() {



    class SpecialOffersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val city: TextView = itemView.findViewById(R.id.city)
        val name: TextView = itemView.findViewById(R.id.name)
        val price: TextView = itemView.findViewById(R.id.price)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialOffersViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.scpec_offer_item, parent, false)
        return SpecialOffersViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SpecialOffersViewHolder, position: Int) {
        when(position) {
            0->holder.itemView.layoutParams = ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.WRAP_CONTENT,
                    ConstraintLayout.LayoutParams.WRAP_CONTENT
                ).also { it.setMargins(20.px, 0, 0, 0) }
            houses.size-1 -> holder.itemView.layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
                ).also { it.setMargins(10.px, 0, 20.px, 0) }

        }
        holder.name.text =  houses[position].name
        holder.city.text =  houses[position].city
        holder.price.text = houses[position].price
    }

    override fun getItemCount(): Int {
        return houses.size
    }

}