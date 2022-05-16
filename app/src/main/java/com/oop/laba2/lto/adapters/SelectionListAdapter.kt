package com.oop.laba2.lto.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oop.laba2.lto.R
import com.oop.laba2.lto.enteties.House

class SelectionListAdapter(val houses: MutableList<House>, val isEmpty: Boolean): RecyclerView.Adapter<SelectionListAdapter.SelectionListViewHolder>() {

    class SelectionListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val arrowIV = itemView.findViewById<ImageView>(R.id.arrowIV)
        val plusIV = itemView.findViewById<ImageView>(R.id.plusIV)
        val imageIV = itemView.findViewById<ImageView>(R.id.imageIV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectionListViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.selections_list_item, parent, false)
        return SelectionListAdapter.SelectionListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SelectionListViewHolder, position: Int) {
        if(isEmpty)
        {
            holder.imageIV.visibility = View.INVISIBLE
            holder.arrowIV.visibility = View.INVISIBLE
        }else{
            if(itemCount == position+1){
                holder.imageIV.visibility = View.INVISIBLE
                holder.plusIV.visibility = View.INVISIBLE
                }
        }
    }

    override fun getItemCount(): Int {

        return if(!isEmpty)
            if(houses.size < 4)
                houses.size+1
            else
                4
        else
            1
    }
}