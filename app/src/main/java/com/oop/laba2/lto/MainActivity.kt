package com.oop.laba2.lto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import android.view.View
import java.sql.RowId


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = NavigationHomeFragment.newInstance()
        val selectionsFragment = NavigationSelectionsFragment.newInstance()
        val profileFiltersAreaFragment = FiltersAreaFragment.newInstance()

        val navigation = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    loadFragment(homeFragment)
                }
                R.id.navigation_selections -> {
                    loadFragment(selectionsFragment)
                }
                R.id.navigation_profile -> {
                    loadFragment(profileFiltersAreaFragment)
                }
            }
            true
        }
        navigation.selectedItemId = R.id.navigation_home
    }
    private fun loadFragment(fragment: Fragment) {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.frame_layout, fragment)
        ft.commit()
    }
}
