package com.example.prathamachikitse

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class SettingsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        updateProfileDisplay(view)
        setupClickListeners(view)
        return view
    }

    private fun setupClickListeners(view: View) {
        // Logout
        view.findViewById<AppCompatButton>(R.id.logoutButton).setOnClickListener {
            val sharedPref = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            sharedPref.edit().apply {
                putBoolean("isLoggedIn", false)
                putString("current_user_phone", null) // Clear current session user
                commit()
            }

            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            requireActivity().finish()
        }

        // Create/Edit Profile
        view.findViewById<CardView>(R.id.createProfileCard).setOnClickListener {
            startActivity(Intent(requireContext(), ProfileActivity::class.java))
        }

        view.findViewById<CardView>(R.id.profileInfoCard).setOnClickListener {
            startActivity(Intent(requireContext(), ProfileActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        view?.let { updateProfileDisplay(it) }
    }

    private fun updateProfileDisplay(view: View) {
        val sharedPref = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val currentPhone = sharedPref.getString("current_user_phone", "") ?: ""
        val profileCreated = sharedPref.getBoolean("profile_created_$currentPhone", false)

        val profileInfoCard = view.findViewById<CardView>(R.id.profileInfoCard)
        val createProfileCard = view.findViewById<CardView>(R.id.createProfileCard)

        if (profileCreated) {
            profileInfoCard.visibility = View.VISIBLE
            createProfileCard.visibility = View.GONE

            val name = sharedPref.getString("name_$currentPhone", "")
            val phone = sharedPref.getString("phone_$currentPhone", currentPhone)
            val email = sharedPref.getString("email_$currentPhone", "")

            view.findViewById<TextView>(R.id.profileName).text = name
            view.findViewById<TextView>(R.id.profileContact).text = phone

            val emailTextView = view.findViewById<TextView>(R.id.profileEmail)
            if (email.isNullOrEmpty()) {
                emailTextView.text = "No mail id given"
            } else {
                emailTextView.text = email
            }
        } else {
            profileInfoCard.visibility = View.GONE
            createProfileCard.visibility = View.VISIBLE
        }
    }
}