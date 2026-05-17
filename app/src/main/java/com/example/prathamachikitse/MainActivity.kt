package com.example.prathamachikitse

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var iconEmergency: TextView
    private lateinit var textEmergency: TextView
    private lateinit var iconSettings: TextView
    private lateinit var textSettings: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        viewPager = findViewById(R.id.viewPager)
        iconEmergency = findViewById(R.id.iconEmergency)
        textEmergency = findViewById(R.id.textEmergency)
        iconSettings = findViewById(R.id.iconSettings)
        textSettings = findViewById(R.id.textSettings)

        setupViewPager()
        setupBottomNavigation()
    }

    private fun setupViewPager() {
        val adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = 2

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> EmergencyFragment()
                    else -> SettingsFragment()
                }
            }
        }
        viewPager.adapter = adapter

        // Sync ViewPager swipe with Bottom Nav icons
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateBottomNavUI(position == 0)
            }
        })
    }

    private fun setupBottomNavigation() {
        findViewById<LinearLayout>(R.id.navEmergency).setOnClickListener {
            viewPager.currentItem = 0
        }

        findViewById<LinearLayout>(R.id.navSettings).setOnClickListener {
            viewPager.currentItem = 1
        }
    }

    private fun updateBottomNavUI(isEmergency: Boolean) {
        if (isEmergency) {
            // Emergency tab active
            iconEmergency.setBackgroundResource(R.drawable.emergency_nav_bg)
            iconEmergency.setTextColor(ContextCompat.getColor(this, R.color.white))
            textEmergency.setTextColor(ContextCompat.getColor(this, R.color.maroon_dark))
            textEmergency.paint.isFakeBoldText = true

            // Settings tab inactive
            iconSettings.background = null
            iconSettings.setTextColor(ContextCompat.getColor(this, R.color.gray_nav))
            textSettings.setTextColor(ContextCompat.getColor(this, R.color.gray_nav))
            textSettings.paint.isFakeBoldText = false
        } else {
            // Settings tab active
            iconSettings.setBackgroundResource(R.drawable.emergency_nav_bg)
            iconSettings.setTextColor(ContextCompat.getColor(this, R.color.white))
            textSettings.setTextColor(ContextCompat.getColor(this, R.color.maroon_dark))
            textSettings.paint.isFakeBoldText = true

            // Emergency tab inactive
            iconEmergency.background = null
            iconEmergency.setTextColor(ContextCompat.getColor(this, R.color.gray_nav))
            textEmergency.setTextColor(ContextCompat.getColor(this, R.color.gray_nav))
            textEmergency.paint.isFakeBoldText = false
        }
    }
}