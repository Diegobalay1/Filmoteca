package com.diego.kotlin.filmoteca

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FilmEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_edit)

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
    }
    companion object {
        const val EXTRA_FILM_INDEX = "EXTRA_FILM_INDEX"
    }
}