package com.cibertec.cibertecapp.news

import com.google.firebase.firestore.GeoPoint

data class News(
    val contenido: String,
    val estado: Boolean,
    val fecha: String,
    val imagen: String,
    val titulo: String,
    val marker: GeoPoint
)
