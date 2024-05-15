package com.example.models.tables

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ReferenceOption

object TablaPuntos: IntIdTable() {
    val cantidad = integer("cantidad")
    val codigo: Column<String>  = varchar("codigo", 10)
    val usuario = reference("usuario", TablaUsuario.id, onDelete = ReferenceOption.CASCADE)
    val puntosRecompesas = reference("puntosRecompe", TablaPuntosRecompensas.id, onDelete = ReferenceOption.CASCADE)
}