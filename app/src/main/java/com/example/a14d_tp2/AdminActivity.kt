package com.example.a14d_tp2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a14d_tp2.databinding.ActivityMainBinding


class AdminActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        //Déclaration du Toolbar
        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        // Déclaration du bouton switch
        val btnSwitch = binding.tbar

        // Titre et sous-titre
        supportActionBar?.title = "Admin"


        // Bouton retour
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        // Actions sur les items du bouton switch
        btnSwitch.setOnCheckedChangeListener{ _, isChecked ->
            if(!isChecked) {
                intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    // // Actions sur le menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_admin -> {

                val intent = Intent(this, AdminActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}