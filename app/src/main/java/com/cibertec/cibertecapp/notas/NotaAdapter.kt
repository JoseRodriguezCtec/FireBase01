package com.cibertec.cibertecapp.notas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NotaAdapter: RecyclerView.Adapter<NotaViewHolder>(){

    private var list = emptyList<Nota>()

    fun setNotas(notas: List<Nota>){
        this.list = notas
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotaViewHolder {
       val inflater = LayoutInflater.from(parent.context)
        return NotaViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NotaViewHolder, position: Int) {
        val nota = list[position]
        holder.data(nota)
    }


}