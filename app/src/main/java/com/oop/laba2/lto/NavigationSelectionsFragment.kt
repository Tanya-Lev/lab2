package com.oop.laba2.lto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oop.laba2.lto.adapters.SelectionAdapter
import com.oop.laba2.lto.enteties.House
import com.oop.laba2.lto.enteties.Selection

class NavigationSelectionsFragment : Fragment() {

    lateinit var adapter:SelectionAdapter
    fun getRandomHouseList():MutableList<House>{
        val list = mutableListOf<House>()
        val random = (0..4).random()
        for (i in 0..random){
            list.add(House())
        }

        return list
    }

    val selectionList = mutableListOf<Selection>(
        Selection(houses=getRandomHouseList()),
        Selection(houses=getRandomHouseList()),
        Selection(houses=getRandomHouseList()),
        Selection(houses=getRandomHouseList(),name="qweqwe" ),
        Selection(houses=getRandomHouseList()),
    )
    companion object {
        fun newInstance() = NavigationSelectionsFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.navigation_selections_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val itemCallback = object : SelectionCallback{
            override fun pressDelete(index:Int) {
                selectionList.removeAt(index)
                adapter.notifyDataSetChanged()
            }

            override fun pressEditName(index:Int) {
            }

            override fun pressShare(index:Int) {
            }

        }

        adapter =  SelectionAdapter(selectionList,itemCallback)
        val selectionsRV = requireActivity().findViewById<RecyclerView>(R.id.selectionsRV)
        selectionsRV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
        selectionsRV.adapter = adapter

        val addNewSelection = requireActivity().findViewById<Button>(R.id.addNewSelection)
        addNewSelection.setOnClickListener {
            selectionList.add(Selection("Новая подборка", mutableListOf<House>()))
            adapter.notifyDataSetChanged()
        }
    }


}