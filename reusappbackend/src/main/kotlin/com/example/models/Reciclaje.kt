package com.example.models

import com.example.models.enums.TipoMaterial
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
class Reciclaje(
    val material: TipoMaterial,
    val peso: Double,
    @Contextual
    val fecha: LocalDate,
    var usuario: Usuario,
)

