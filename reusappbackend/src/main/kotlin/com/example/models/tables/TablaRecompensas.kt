package com.example.models.tables

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption

object TablaRecompensas: IntIdTable() {
    val nombre = varchar("nombre", 50)
    val minPuntos = integer("minPuntos")
    val descripcion = varchar("descripcion", 200)
    val puntosRecompensas = reference("puntosRecompensas", TablaPuntosRecompensas.id, onDelete = ReferenceOption.CASCADE)
    val usuarioRecompensas = reference("usuarioRecompensas", TablaUsuariosRecompensas.id, onDelete = ReferenceOption.CASCADE)
}