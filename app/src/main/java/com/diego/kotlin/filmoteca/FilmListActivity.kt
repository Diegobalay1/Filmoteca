package com.diego.kotlin.filmoteca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListAdapter
import android.widget.ListView

class FilmListActivity : AppCompatActivity() {
    var adapter : ListAdapter? = null
    var listView: ListView? = null
    //var peliculas = FilmDataSource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_film_list)

        /*val btnPeliculaA = findViewById<Button>(R.id.btnPeliculaA)
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
        }*/

        //adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, peliculas.films)
        //adapter = FilmAdapterListView(this, R.layout.item_lenguaje, peliculas.films)
        adapter = FilmAdapterListView(this, R.layout.item_lenguaje, FilmDataSource.films)
        listView = ListView(this)
        listView?.adapter = adapter
        setContentView(listView)

        listView?.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this@FilmListActivity, FilmDataActivity::class.java)
            intent.putExtra(FilmDataActivity.EXTRA_FILM_INDEX, position)
            startActivity(intent)
        }
    }


}