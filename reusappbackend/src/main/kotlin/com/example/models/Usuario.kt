package com.example.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
class Usuario (
    val nombre: String,
    val apellido: String,
    protected val cedula: Int,
    protected val telefono: Int,
    @Contextual
    private val fechaRegistro:LocalDate,
    val cuenta: Cuenta,
    val direccion: Direccion,
    val reciclajes: MutableList<Reciclaje>,
    @Contextual
    val puntos: Puntos,
    @Contextual
    var recompensas: Recompensas
) {
    fun agregarReciclaje(reciclaje: Reciclaje) {
        reciclajes.add(reciclaje)
        reciclaje.usuario = this
    }

    init{
        recompensas=recompensas.coleccionRecompensas
    }

}
