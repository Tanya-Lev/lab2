package com.oop.laba2.lto.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.oop.laba2.lto.R
import com.oop.laba2.lto.Utils.px
import com.oop.laba2.lto.enteties.House


class CatalogAdapter(val apartments: List<House>, val rootFragmentView: View?):RecyclerView.Adapter<CatalogAdapter.CatalogViewHolder>(){
    class CatalogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val dashboardBtn: ImageView = itemView.findViewById(R.id.dashboardBtn)
        val heartBtn: ImageButton = itemView.findViewById(R.id.heartBtn)
        val imageCatalog: ImageView = itemView.findViewById(R.id.imageCatalog)

        val statusTV: TextView = itemView.findViewById(R.id.statusTV)
        val numberTV: TextView = itemView.findViewById(R.id.numberTV)
        val complexTV: TextView = itemView.findViewById(R.id.complexTV)
        val priceTV: TextView = itemView.findViewById(R.id.priceTV)
        val addressTV: TextView = itemView.findViewById(R.id.addressTV)
        val infoTV: TextView = itemView.findViewById(R.id.infoTV)

        val statusPlace: CardView = itemView.findViewById(R.id.statusPlace)
        val numberPlace: CardView = itemView.findViewById(R.id.numberPlace)


        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.catalog_item, parent, false)
        return CatalogViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        var isFavoriteSelected = false
        holder.statusTV.text =  apartments[position].status
        holder.numberTV.text =  apartments[position].number
        holder.complexTV.text = apartments[position].complex
        holder.priceTV.text = apartments[position].price
        holder.addressTV.text = apartments[position].address
        holder.infoTV.text = apartments[position].info
        holder.heartBtn.setOnClickListener { it ->
            if(isFavoriteSelected){
                (it as ImageButton).setColorFilter(ContextCompat.getColor(holder.itemView.context, R.color.favorite_unselected))
                Snackbar.make(rootFragmentView!!,"Объект убран из Избранного" , Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(holder.itemView.context.getColor(R.color.white))
                    .also {
                        it.setTextColor(holder.itemView.context.getColor(R.color.dark1))
                        val layout = it.view
                        val textView = layout.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
                        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_done, 0, 0, 0)
                        textView.compoundDrawablePadding = 14.px
                        textView.textAlignment=View.TEXT_ALIGNMENT_TEXT_START
                    }
                    
                    .show()

            }else{

                (it as ImageButton).setColorFilter(ContextCompat.getColor(holder.itemView.context,
                    R.color.favorite_selected
                ))
                Snackbar.make(rootFragmentView!!,"Объект добавлен в Избранное" , Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(holder.itemView.context.getColor(R.color.white))
                    .also {
                        it.setTextColor(holder.itemView.context.getColor(R.color.dark1))
                        val layout = it.view
                        val textView = layout.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
                        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_done, 0, 0, 0)
                        textView.compoundDrawablePadding = 14.px
                        textView.textAlignment=View.TEXT_ALIGNMENT_TEXT_START



                    }
                    .show()
            }
            isFavoriteSelected = !isFavoriteSelected
        }
    }

    override fun getItemCount(): Int {
        return apartments.size
    }
}


