package com.oop.laba2.lto

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider

import com.oop.laba2.lto.adapters.CatalogAdapter
import com.oop.laba2.lto.adapters.SpecialOffersAdapter
import kotlinx.android.synthetic.main.filters_area_fragment.*
import java.text.NumberFormat
import java.util.*


class FiltersAreaFragment: Fragment() {
    companion object {
        fun newInstance() = FiltersAreaFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.filters_area_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val sliderr = requireActivity().findViewById<com.google.android.material.slider.RangeSlider>(R.id.slider)
        val fromTV = requireActivity().findViewById<EditText>(R.id.editTextFrom)
        val toTV = requireActivity().findViewById<EditText>(R.id.editTextTo)


        fromTV.setText(sliderr.values[0].toInt().toString())
        toTV.setText(sliderr.values[1].toInt().toString())


        sliderr.addOnChangeListener { rangeSlider, value, fromUser ->
            val values = sliderr.values
            fromTV.setText(values[0].toInt().toString())
            toTV.setText(values[1].toInt().toString())
        }

        sliderr.setLabelFormatter { value: Float ->
            val format = NumberFormat.getIntegerInstance()
            format.maximumFractionDigits = 0
            format.format(value.toInt())
        }


//        sliderr.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
//            override fun onStartTrackingTouch(slider: Slider) {
//                println("Start Tracking Touch")
//                thi
//            }
//
//            override fun onStopTrackingTouch(slider: Slider) {
//                println("Stop Tracking Touch")
//            }
//        })

    }

}


