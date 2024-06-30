package com.cibertec.cibertecapp.cursos

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cibertecapp.R

class CursosViewHolder(inflater: LayoutInflater, viewGroup: ViewGroup):
RecyclerView.ViewHolder(inflater.inflate(R.layout.item_curso, viewGroup, false)) {

    private var imgCurso: ImageView? = null
    private var textCurso: TextView? = null

    init {
        imgCurso = itemView.findViewById(R.id.imgCurso)
        textCurso = itemView.findViewById(R.id.textCurso)
    }

    fun bind(curso: Curso) {
        textCurso?.text = curso.nombre
        imgCurso?.setImageResource(curso.imagen)
    }

}