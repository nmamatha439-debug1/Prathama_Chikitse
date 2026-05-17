package com.example.prathamachikitse

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getStringExtra("EMERGENCY_TYPE") ?: "Details"
        val english = intent.getStringExtra("ENGLISH_TEXT") ?: ""
        val kannada = intent.getStringExtra("KANNADA_TEXT") ?: ""

        findViewById<TextView>(R.id.titleText).text = title
        findViewById<TextView>(R.id.englishContent).text = english
        findViewById<TextView>(R.id.kannadaContent).text = kannada

        findViewById<ImageButton>(R.id.backButton).setOnClickListener {
            finish()
        }
    }
}