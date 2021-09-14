package com.diego.kotlin.filmoteca

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class FilmAdapterListView(context: Context?, resource: Int, objects: List<Film>?)
    : ArrayAdapter<Film>(context!!, resource, objects!!) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var view: View = convertView?:
                    LayoutInflater.from(this.context)
                        .inflate(R.layout.item_lenguaje,parent, false)
            val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
            val tvDirector = view.findViewById<TextView>(R.id.tvDirector)
            val imgCaratula = view.findViewById<ImageView>(R.id.caratulaImg)

            getItem(position)?.let {
                tvTitle.text = it.title
                tvDirector.text = it.director
                imgCaratula.setImageResource(it.imageResId)
            }

            return view
        }//end getView()
}