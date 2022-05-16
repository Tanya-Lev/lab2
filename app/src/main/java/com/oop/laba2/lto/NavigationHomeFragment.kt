package com.oop.laba2.lto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oop.laba2.lto.adapters.CatalogAdapter
import com.oop.laba2.lto.adapters.SpecialOffersAdapter
import com.oop.laba2.lto.enteties.House

class NavigationHomeFragment : Fragment() {

    val houseList = listOf<House>(
        House(),
        House(),
        House(),
        House(),
        House(),
        House(),
    )

    companion object {
        fun newInstance() = NavigationHomeFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.navigation_home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val specialOffersRV = requireActivity().findViewById<RecyclerView>(R.id.specialOffersRV)
        specialOffersRV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        specialOffersRV.adapter = SpecialOffersAdapter(houseList)

        val catalogRV = requireActivity().findViewById<RecyclerView>(R.id.catalogRV)
        catalogRV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        catalogRV.adapter = CatalogAdapter(houseList , view)
    }

}