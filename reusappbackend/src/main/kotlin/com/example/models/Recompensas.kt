package com.example.models
import kotlinx.serialization.Serializable

@Serializable
class Recompensas (
    val nombre: String,
    val minPuntos: Int,
    val descripcion: String,
    private var puntos: Puntos,
    val usuario: Usuario
)
