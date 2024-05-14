package com.example.models
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
class UsuariosRecompensas(
    val usuario: Usuario,
    val recompensa: Recompensas,
    val puntosRecompensas: PuntosRecompensas
)