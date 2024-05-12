package com.example.models
import kotlinx.serialization.Serializable

@Serializable
class Direccion(
    val detalles: String,
    val barrio: String,
    val descripcion: String,
    val comuna: Int,
    val codigoPostal: Int,
    )
