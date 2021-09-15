package com.diego.kotlin.filmoteca

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class FilmDataActivity : AppCompatActivity() {
    //var titulo = ""
    var filmIndex = 0
    //var peliculas = FilmDataSource()

    companion object {
        const val EXTRA_FILM_TITLE = "EXTRA_FILM_TITLE"
        const val EXTRA_FILM_INDEX = "EXTRA_FILM_INDEX"
        private const val REQUEST_CODE_EDIT = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_data)

        /*intent.getStringExtra(EXTRA_FILM_TITLE)?.let {
            titulo = it
        }*/

        filmIndex = intent.getIntExtra(EXTRA_FILM_INDEX, -1)

        //val txtTitulo = findViewById<TextView>(R.id.txtDataTitle)
        val btnImdb = findViewById<Button>(R.id.btnImdb)
        val btnEditar = findViewById<Button>(R.id.btnDataEditar)
        val btnVolver = findViewById<Button>(R.id.btnDataVolver)

        //txtTitulo.text = titulo

        btnImdb.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://www.imdb.com/title/tt0088763/?ref_=nv_sr_1")
            startActivity(intent)
        }
        btnEditar.setOnClickListener {
            val intent = Intent(this@FilmDataActivity, FilmEditActivity::class.java)
            intent.putExtra(FilmEditActivity.EXTRA_FILM_INDEX, filmIndex)
            startActivityForResult(intent, REQUEST_CODE_EDIT)
        }
        btnVolver.setOnClickListener {
            val intent = Intent(this@FilmDataActivity, FilmListActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        updateFilmData()

    }//end onCreate()

    private fun updateFilmData() {
        val txtTitulo = findViewById<TextView>(R.id.txtDataTitle)
        val txtAnyo = findViewById<TextView>(R.id.txtDataYear)
        val txtDirector = findViewById<TextView>(R.id.txtDataDirector)
        val txtComentarios = findViewById<TextView>(R.id.txtDataComments)
        val txtFormatoGenero = findViewById<TextView>(R.id.txtDataFormatGenre)
        val imgPoster = findViewById<ImageView>(R.id.ivPoster)
        //val film = peliculas.films[filmIndex]
        val film = FilmDataSource.films[filmIndex]

        val formato = resources.getStringArray(R.array.formats)[film.format].toString()
        val separadorComa = resources.getString(R.string.separador_coma)
        val genero = resources.getStringArray(R.array.genres)[film.genre].toString()

        txtTitulo.text = film.title
        txtDirector.text = film.director
        txtAnyo.text = ""+film.year
        txtComentarios.text = film.comments
        /*txtFormatoGenero.text = resources.getStringArray(R.array.formats)[film.format].toString() +
                ", " + resources.getStringArray(R.array.genres)[film.genre]*/
        txtFormatoGenero.text = formato + separadorComa + genero
        imgPoster.setImageResource(film.imageResId)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_EDIT && resultCode == Activity.RESULT_OK) {
            /*val txtTitulo = findViewById<TextView>(R.id.txtDataTitle)
            titulo = "$titulo-mod"
            txtTitulo.text = titulo*/
            updateFilmData()
        }
    }

}









