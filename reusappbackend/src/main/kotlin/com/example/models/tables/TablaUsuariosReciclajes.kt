package com.example.models.tables

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption

object TablaUsuariosReciclajes : IntIdTable() {
    val usuario = reference("usuario", TablaUsuario.id, onDelete = ReferenceOption.CASCADE)
    val reciclaje = reference("reciclaje", TablaReciclaje.id, onDelete = ReferenceOption.CASCADE)
}
