package com.diego.kotlin.filmoteca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FilmListActivity : AppCompatActivity() {
    var adapter : ArrayAdapter<Film>? = null
    var listView: ListView? = null
    //var peliculas = FilmDataSource()

    /*var recyclerView: RecyclerView? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    var adapter: FilmAdapterRecyclerView? = null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_recycler_list)

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
        adapter = FilmAdapterListView(this, R.layout.item_film, FilmDataSource.films)
        listView = ListView(this)
        listView?.adapter = adapter


        listView?.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this@FilmListActivity, FilmDataActivity::class.java)
            intent.putExtra(FilmDataActivity.EXTRA_FILM_INDEX, position)
            startActivity(intent)
        }

        listView?.choiceMode = ListView.CHOICE_MODE_MULTIPLE_MODAL
        listView?.setMultiChoiceModeListener(
            object : AbsListView.MultiChoiceModeListener {
                override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                    val inflater = mode?.menuInflater
                    inflater?.inflate(R.menu.film_list_contextual_menu, menu)
                    return true
                }

                override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                    return false
                }

                override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                    return when (item?.itemId) {
                        R.id.miBorrar -> {
                            borrarItemsSeleccionados()
                            mode?.finish()
                            true
                        }
                        else -> false
                    }
                }

                override fun onDestroyActionMode(mode: ActionMode?) {

                }

                override fun onItemCheckedStateChanged(
                    mode: ActionMode?,
                    position: Int,
                    id: Long,
                    checked: Boolean
                ) {

                }

            }
        )

        setContentView(listView)

        /*recyclerView = findViewById(R.id.lista_films)

        layoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.itemAnimator = DefaultItemAnimator()

        adapter = FilmAdapterRecyclerView(FilmDataSource.films)
        recyclerView?.adapter = adapter
        adapter?.setOnItemClickListener { f, position ->
            val intent = Intent(this@FilmListActivity, FilmDataActivity::class.java)
            intent.putExtra(FilmDataActivity.EXTRA_FILM_INDEX, position)
            startActivity(intent)
        }*/

    }//end onCreate()

    private fun borrarItemsSeleccionados() {
        listView?.let {
            val indices = it.checkedItemPositions
            val toDelete: MutableList<Film> = ArrayList()
            for (i in 0 until indices.size()) {
                if (indices.valueAt(i)) {
                    toDelete.add(FilmDataSource.films[indices.keyAt(i)])
                }
            }
            FilmDataSource.films.removeAll(toDelete)
            adapter?.notifyDataSetChanged()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.film_list_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return when (item.itemId) {
            R.id.miNuevaPelicula -> {
                nuevaPelicula()
                true
            }
            R.id.miAcercaDe -> {
                abrirAcercaDe()
                true
            }
            else -> false
        }
    }

    private fun abrirAcercaDe() {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }

    private fun nuevaPelicula() {
        val f = Film()
        FilmDataSource.films.add(f)
        adapter?.notifyDataSetChanged()
        /*val f = Film()
        f.title = "New Movie"
        f.imageResId = R.mipmap.ic_launcher
        FilmDataSource.films.add(f)
        adapter?.notifyItemInserted(FilmDataSource.films.size - 1)*/
    }

}












