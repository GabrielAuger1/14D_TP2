package com.example.a14d_tp2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)


        val toolbar = findViewById<Toolbar>(R.id.)
        setSupportActionBar(toolbar)

        // Titre et sous-titre
        supportActionBar?.title = "Admin"
        supportActionBar?.subtitle = "A2024"

        // Bouton retour
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}