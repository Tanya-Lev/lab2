package com.oop.laba2.lto.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oop.laba2.lto.R
import com.oop.laba2.lto.SelectionCallback
import com.oop.laba2.lto.enteties.Selection

class SelectionAdapter(val selections: List<Selection>, val itemCallback: SelectionCallback):RecyclerView.Adapter<SelectionAdapter.SelectionViewHolder>() {
    class SelectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val selectionNameTV: TextView = itemView.findViewById(R.id.selectionNameTV)
        val selectionsListRV: RecyclerView = itemView.findViewById(R.id.selectionsListRV)
        val deleteIV = itemView.findViewById<ImageView>(R.id.deleteIV)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectionViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.selections_item, parent, false)
        return SelectionAdapter.SelectionViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SelectionViewHolder, position: Int) {
        holder.selectionNameTV.text =  selections[position].name
        holder.selectionsListRV.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        holder.selectionsListRV.adapter = SelectionListAdapter(selections[position].houses,selections[position].houses.size == 0)
        holder.deleteIV.setOnClickListener{
            itemCallback.pressDelete(position)
        }
    }

    override fun getItemCount(): Int {
        return selections.size
    }
}