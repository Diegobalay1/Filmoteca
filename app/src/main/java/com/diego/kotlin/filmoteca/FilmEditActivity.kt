package com.diego.kotlin.filmoteca

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

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
            setResult(Activity.RESULT_OK)
            finish()
        }
        btnCancelar.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

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

}
















