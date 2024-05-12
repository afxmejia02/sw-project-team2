package com.example.models
import kotlinx.serialization.Serializable

@Serializable
class Recompensas (
    val nombre: String,
    val minPuntos: Int,
    val descripcion: String,
    val coleccionRecompensas: MutableList<Recompensas>,
    private var puntos: Puntos,
    //val usuario: Usuario
){

    fun verificarPuntos(): Boolean{
        return puntos.cantidad >= minPuntos
    }

    fun agregarRecompensas() {
        if (verificarPuntos()) coleccionRecompensas.add(this)
    }





}