package com.cibertec.cibertecapp.notas

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotaDAO {

    @Insert
    fun insert(nota: Nota)

    @Update
    fun update(nota: Nota)

    @Delete
    fun delete(nota: Nota)

    @Query("SELECT * FROM note_table")
    fun list(): LiveData<List<Nota>>

}