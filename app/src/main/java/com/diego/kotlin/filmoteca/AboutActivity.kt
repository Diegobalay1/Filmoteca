package com.diego.kotlin.filmoteca

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.core.app.NavUtils

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

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //supportActionBar?.setHomeAsUpIndicator(R.mipmap.ic_launcher)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                NavUtils.navigateUpTo(this, Intent(
                    this, FilmListActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}