package com.cibertec.cibertecapp.cursos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CursosAdapter(val list: List<Curso>):
RecyclerView.Adapter<CursosViewHolder>(){

    // Instancia el ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursosViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CursosViewHolder(inflater, parent)
    }

    // Indica el num elementos a mostrar
    override fun getItemCount(): Int {
        return list.size
    }

    // Asignarle datos al viewholder
    override fun onBindViewHolder(holder: CursosViewHolder, position: Int) {
        val curso = list[position]
        holder.bind(curso)
    }

}