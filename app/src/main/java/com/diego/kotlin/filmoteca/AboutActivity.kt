package com.diego.kotlin.filmoteca

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val btnSupport = findViewById<Button>(R.id.btnSupport)
        val btnWebsite = findViewById<Button>(R.id.btnWebsite)
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnSupport.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:ejemplodiego@gmail.com"))
            startActivity(intent)
        }
        btnWebsite.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://eps.ua.es/master-moviles"))
            startActivity(intent)
        }
        btnBack.setOnClickListener { finish() }
    }
}