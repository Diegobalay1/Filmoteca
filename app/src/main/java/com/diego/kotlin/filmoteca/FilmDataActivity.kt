package com.diego.kotlin.filmoteca

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class FilmDataActivity : AppCompatActivity() {
    var titulo = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_data)

        intent.getStringExtra(EXTRA_FILM_TITLE)?.let {
            titulo = it
        }

        val txtTitulo = findViewById<TextView>(R.id.txtDataTitle)
        val btnImdb = findViewById<Button>(R.id.btnImdb)
        val btnEditar = findViewById<Button>(R.id.btnDataEditar)
        val btnVolver = findViewById<Button>(R.id.btnDataVolver)

        txtTitulo.text = titulo

        btnImdb.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://www.imdb.com/title/tt0088763/?ref_=nv_sr_1")
            startActivity(intent)
        }
        btnEditar.setOnClickListener {
            val intent = Intent(this@FilmDataActivity, FilmEditActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_EDIT)
        }
        btnVolver.setOnClickListener {
            val intent = Intent(this@FilmDataActivity, FilmListActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

    }//end onCreate()

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_EDIT && resultCode == Activity.RESULT_OK) {
            val txtTitulo = findViewById<TextView>(R.id.txtDataTitle)
            titulo = "$titulo-mod"
            txtTitulo.text = titulo
        }
    }


    companion object {
        const val EXTRA_FILM_TITLE = "EXTRA_FILM_TITLE"
        private const val REQUEST_CODE_EDIT = 1
    }
}