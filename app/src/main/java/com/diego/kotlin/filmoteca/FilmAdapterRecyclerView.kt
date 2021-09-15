package com.diego.kotlin.filmoteca

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView

class FilmAdapterRecyclerView(private val films: List<Film>): RecyclerView.Adapter<FilmAdapterRecyclerView.ViewHolder>() {

    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {
        var titulo: TextView
        var director: TextView
        var poster: ImageView

        init {
            titulo = v.findViewById(R.id.tvTitle)
            director = v.findViewById(R.id.tvDirector)
            poster = v.findViewById(R.id.caratulaImg)
        }

        fun bind(f: Film) {
            titulo.text = f.title
            director.text = f.director
            poster.setImageResource(f.imageResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_film, parent, false)
        val holder = ViewHolder(v)
        v.setOnClickListener {
            val position = holder.adapterPosition
            films[position]?.let { listener(it, position) }
        }

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(films[position])
    }

    override fun getItemCount(): Int {
        return films.size
    }

    // Listener para la lista
    private var listener: (f: Film, pos: Int) -> Unit = {_, _ -> }

    fun setOnItemClickListener(listener: (f: Film, position: Int) -> Unit) {
        this.listener = listener //Guardamos una referencia al listener
    }

}