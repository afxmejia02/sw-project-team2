package com.example.models

import com.example.models.enums.TipoMaterial
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
class Usuario(
    val nombre: String,
    val apellido: String,
    protected val cedula: Int,
    protected val telefono: Int,
    @Contextual
    private val fechaRegistro:LocalDate,
    val cuenta: Cuenta,
    val direccion: Direccion,
    val reciclajes: MutableList<Reciclaje> = mutableListOf(),
    @Contextual
    val puntos: Puntos,
    @Contextual
    val recompensa: UsuariosRecompensas,
    val recompensas: MutableList<Recompensas> = mutableListOf(),

) {
    fun agregarReciclaje(reciclaje: Reciclaje) {
        reciclajes.add(reciclaje)
        reciclaje.usuario = this
    }



    fun agregarRecompensas(recompensas: List<Recompensas>) {
        for (recompense in recompensas) {
            if (this.recompensa.puntosRecompensas.verificarPuntos() && !this.recompensas.contains(recompense)) {
                this.recompensas.add(recompense)
            }
        }
    }





}