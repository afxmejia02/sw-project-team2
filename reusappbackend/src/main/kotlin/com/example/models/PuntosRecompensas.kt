package com.example.models
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
class PuntosRecompensas (
    @Contextual
    val punto: Puntos,
    @Contextual
    val recompensa: Recompensas
){
    fun verificarPuntos(): Boolean{
        return punto.cantidad >= recompensa.minPuntos
    }

    fun restarPuntos(): Int {
        return if (verificarPuntos()) {
            recompensa.minPuntos
        } else {
            0
        }
    }

}
