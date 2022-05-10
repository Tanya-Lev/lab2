package com.oop.laba2.lto

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oop.laba2.lto.adapters.CatalogAdapter
import com.oop.laba2.lto.adapters.SpecialOffersAdapter
import com.oop.laba2.lto.enteties.House

import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.core.graphics.toColorFilter


class MainActivity : AppCompatActivity() {
    val houseList = listOf<House>(
        House(),
        House(),
        House(),
        House(),
        House(),
        House(),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val specialOffersRV = findViewById<RecyclerView>(R.id.specialOffersRV)
        specialOffersRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        specialOffersRV.adapter = SpecialOffersAdapter(houseList)

        val catalogRV = findViewById<RecyclerView>(R.id.catalogRV)
        catalogRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        catalogRV.adapter = CatalogAdapter(houseList)


//        val button = findViewById<ImageButton>(R.id.heartBtn)
//        button.setOnClickListener{
//            button.setColorFilter(454545)
//        }
    }
}