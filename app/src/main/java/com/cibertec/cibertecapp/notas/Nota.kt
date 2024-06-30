package com.cibertec.cibertecapp.notas

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Nota(
    @ColumnInfo(name = "date_note")
    val fecha: String,
    @ColumnInfo(name = "title_note")
    val titulo: String,
    @ColumnInfo(name = "description_note")
    val contenido: String
){
    @PrimaryKey(autoGenerate = true )
    @ColumnInfo(name = "id_note")
    var noteId: Int = 0
}