package com.diego.kotlin.filmoteca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FilmListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_list)

        val btnPeliculaA = findViewById<Button>(R.id.btnPeliculaA)
        val btnPeliculaB = findViewById<Button>(R.id.btnPeliculaB)
        val btnAcercaDe = findViewById<Button>(R.id.btnAcercaDe)

        btnPeliculaA.setOnClickListener {
            val intent = Intent(this@FilmListActivity, FilmDataActivity::class.java)
            intent.putExtra(FilmDataActivity.Companion.EXTRA_FILM_TITLE, "A")
            startActivity(intent)
        }
        btnPeliculaB.setOnClickListener {
            val intent = Intent(this@FilmListActivity, FilmDataActivity::class.java)
            intent.putExtra(FilmDataActivity.Companion.EXTRA_FILM_TITLE, "B")
            startActivity(intent)
        }
        btnAcercaDe.setOnClickListener {
            val intent = Intent(this@FilmListActivity, AboutActivity::class.java)
            startActivity(intent)
        }
    }
}