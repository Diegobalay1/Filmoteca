package com.diego.kotlin.filmoteca

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.core.app.NavUtils

class FilmEditActivity : AppCompatActivity() {

    var filmIndex = 0

    companion object {
        const val EXTRA_FILM_INDEX = "EXTRA_FILM_INDEX"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_edit)

        filmIndex = intent.getIntExtra(EXTRA_FILM_INDEX, -1)

        val btnGuardar = findViewById<Button>(R.id.btnEditSave)
        val btnCancelar = findViewById<Button>(R.id.btnEditCancel)

        btnGuardar.setOnClickListener {
            saveFilmData()
            setResult(Activity.RESULT_OK)
            finish()
        }
        btnCancelar.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.mipmap.ic_launcher)

        loadFilmData()
    }

    private fun loadFilmData() {
        val etTitle = findViewById<EditText>(R.id.editTextTitle)
        val etDirector = findViewById<TextView>(R.id.editTextDirector)
        val etAnyo = findViewById<TextView>(R.id.editTextYear)
        val etComentarios = findViewById<TextView>(R.id.editTextComments)
        val etImdb = findViewById<TextView>(R.id.editTextURL)
        val spinnerFormato = findViewById<Spinner>(R.id.spinnerFormat)
        val spinnerGenero = findViewById<Spinner>(R.id.spinnerGenre)
        val imgPoster = findViewById<ImageView>(R.id.imageViewCartel)

        val film = FilmDataSource.films[filmIndex]

        etTitle.setText(film.title)
        etDirector.text = film.director
        etAnyo.text = "" + film.year
        etComentarios.text = film.comments
        etImdb.text = film.imdbUrl
        spinnerFormato.setSelection(film.format, true)
        spinnerGenero.setSelection(film.genre, false)
        imgPoster.setImageResource(film.imageResId)
    }

    private fun saveFilmData() {
        val etTitle = findViewById<EditText>(R.id.editTextTitle)
        val etDirector = findViewById<TextView>(R.id.editTextDirector)
        val etAnyo = findViewById<TextView>(R.id.editTextYear)
        val etComentarios = findViewById<TextView>(R.id.editTextComments)
        val etImdb = findViewById<TextView>(R.id.editTextURL)
        val spinnerFormato = findViewById<Spinner>(R.id.spinnerFormat)
        val spinnerGenero = findViewById<Spinner>(R.id.spinnerGenre)
        val imgPoster = findViewById<ImageView>(R.id.imageViewCartel)

        val film = FilmDataSource.films[filmIndex]
        film.title = etTitle.text.toString()
        film.director = etDirector.text.toString()
        film.year = etAnyo.text.toString().toInt()
        film.comments = etComentarios.text.toString()
        film.imdbUrl = etImdb.text.toString()
        film.genre = spinnerGenero.selectedItemPosition
        film.format = spinnerFormato.selectedItemPosition
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item.itemId) {
            android.R.id.home -> {
                NavUtils.navigateUpTo(this, Intent(
                    this, FilmListActivity::class.java)
                )
                return true
            }
        }
        return false
    }

}
















