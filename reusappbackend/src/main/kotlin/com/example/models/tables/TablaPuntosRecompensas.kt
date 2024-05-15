package com.example.models.tables

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption

object TablaPuntosRecompensas: IntIdTable() {
    val punto = reference("punto", TablaPuntos, onDelete = ReferenceOption.CASCADE)
    val recompensa = reference("recompensa", TablaRecompensas, onDelete = ReferenceOption.CASCADE)
}
