package com.example.models.tables

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption


object TablaCuenta: IntIdTable() {
    val nombre = varchar("nombre", 50).uniqueIndex()
    val hashedPassword = varchar("hashedPassword", 255)
    val correo = varchar("correo", 50)
    val usuarioId = reference("usuarioId", TablaUsuario.id, onDelete = ReferenceOption.CASCADE)
}