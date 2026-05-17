package com.example.prathamachikitse

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class LoginActivity : AppCompatActivity() {

    private val CALL_PERMISSION_REQUEST_CODE = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val contactInput = findViewById<EditText>(R.id.contactInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val forgotPasswordText = findViewById<TextView>(R.id.forgotPasswordText)

        val sosButton = findViewById<Button>(R.id.sosButton)
        sosButton.setOnClickListener {
            makeEmergencyCall()
        }

        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {
            val contact = contactInput.text.toString().trim()
            val password = passwordInput.text.toString()

            if (contact.length != 10) {
                Toast.makeText(this, "Please enter a valid 10-digit number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Password Validation: 1 Capital Letter and 1 Number
            val passwordRegex = "^(?=.*[A-Z])(?=.*[0-9]).+$".toRegex()
            if (!passwordRegex.containsMatchIn(password)) {
                Toast.makeText(this, "Password must contain at least one capital letter and one number", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)
            val savedPassword = sharedPref.getString("pass_$contact", null)

            if (savedPassword != null && savedPassword != password) {
                Toast.makeText(this, "Incorrect password for this number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Save login state and CURRENT session user
            sharedPref.edit().apply {
                putBoolean("isLoggedIn", true)
                putString("current_user_phone", contact)
                // If it's a new user, "register" them by saving their password
                if (savedPassword == null) {
                    putString("pass_$contact", password)
                }
                commit()
            }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        forgotPasswordText.setOnClickListener {
            val sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)
            val phone = contactInput.text.toString().trim()
            
            if (phone.length != 10) {
                Toast.makeText(this, "Enter your 10-digit phone number first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val savedEmail = sharedPref.getString("email_$phone", null)
            val savedPass = sharedPref.getString("pass_$phone", null)

            if (savedPass == null) {
                Toast.makeText(this, "No account found for this number", Toast.LENGTH_SHORT).show()
            } else if (!savedEmail.isNullOrEmpty()) {
                Toast.makeText(this, "Reset link sent to: $savedEmail", Toast.LENGTH_LONG).show()
                // For your testing, we show the password in a toast since we don't have a real mail server yet
                Toast.makeText(this, "DEBUG: Your password is $savedPass", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Reset code sent to phone: $phone", Toast.LENGTH_LONG).show()
                Toast.makeText(this, "DEBUG: Your password is $savedPass", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun makeEmergencyCall() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), CALL_PERMISSION_REQUEST_CODE)
        } else {
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:108")
            startActivity(callIntent)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CALL_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makeEmergencyCall()
            } else {
                Toast.makeText(this, "Permission DENIED to make a call", Toast.LENGTH_SHORT).show()
            }
        }
    }
}