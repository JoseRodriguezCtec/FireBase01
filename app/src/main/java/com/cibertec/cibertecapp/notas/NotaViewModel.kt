package com.cibertec.cibertecapp.notas

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NotaViewModel(application: Application):
    AndroidViewModel(application) {

    private val repository = NotaRepository(application)

    fun getNotas(): LiveData<List<Nota>>{
        return repository.getNotas()
    }

    fun insertNota(nota: Nota){
        viewModelScope.launch {
            repository.insertNota(nota)
        }
    }
}