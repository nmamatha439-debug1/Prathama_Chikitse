package com.example.prathamachikitse

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val editName = findViewById<EditText>(R.id.editName)
        val editPhone = findViewById<EditText>(R.id.editPhone)
        val editEmail = findViewById<EditText>(R.id.editEmail)
        val saveButton = findViewById<Button>(R.id.saveProfileButton)
        val backButton = findViewById<ImageButton>(R.id.profileBackButton)

        val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val currentPhone = sharedPref.getString("current_user_phone", "") ?: ""
        
        // Load data specific to THIS user
        editName.setText(sharedPref.getString("name_$currentPhone", ""))
        editPhone.setText(sharedPref.getString("phone_$currentPhone", currentPhone))
        editEmail.setText(sharedPref.getString("email_$currentPhone", ""))

        backButton.setOnClickListener { finish() }

        saveButton.setOnClickListener {
            val name = editName.text.toString().trim()
            val phone = editPhone.text.toString().trim()
            val email = editEmail.text.toString().trim()

            if (name.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Name and Phone are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            with(sharedPref.edit()) {
                putString("name_$currentPhone", name)
                putString("phone_$currentPhone", phone)
                putString("email_$currentPhone", email)
                putBoolean("profile_created_$currentPhone", true)
                commit()
            }

            Toast.makeText(this, "Profile Saved Successfully", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}