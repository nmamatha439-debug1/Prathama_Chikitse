package com.example.prathamachikitse

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            // Check if user is already logged in
            val sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)
            val isLoggedIn = sharedPref.getBoolean("isLoggedIn", false)

            if (isLoggedIn) {
                // User is logged in, go directly to Home
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                // User is not logged in, go to Login
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()

        }, 2000)
    }
}