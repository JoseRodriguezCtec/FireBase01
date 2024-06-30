package com.cibertec.cibertecapp.cursos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cibertecapp.R

class CursosActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cursos)

        val recyclerCursos = findViewById<RecyclerView>(R.id.recyclerCursos)

        val listCursos = listOf<Curso>(
            Curso("Curso de Android", R.drawable.logo_android),
            Curso("Curso de iOS", R.drawable.logo_apple),
            Curso("Curso de Java", R.drawable.logo_java),
            Curso("Curso de OWASP", R.drawable.logo_owasp)
        )

        val adapter = CursosAdapter(listCursos)
        recyclerCursos.adapter = adapter
        recyclerCursos.layoutManager = LinearLayoutManager(this)
    }

}