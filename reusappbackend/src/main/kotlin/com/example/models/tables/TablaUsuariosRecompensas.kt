package com.example.models.tables

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption

object TablaUsuariosRecompensas: IntIdTable() {
    val usuario = reference("usuario", TablaUsuario.id, onDelete = ReferenceOption.CASCADE)
    val recompensa = reference("recompensa", TablaRecompensas.id,onDelete = ReferenceOption.CASCADE)
    val puntosRecompensas = reference("cantidad",TablaPuntosRecompensas.id, onDelete = ReferenceOption.CASCADE)
    val usuariosRecompensas = reference("usuariosRecompensas", TablaUsuariosRecompensas.id, onDelete = ReferenceOption.CASCADE)
}
