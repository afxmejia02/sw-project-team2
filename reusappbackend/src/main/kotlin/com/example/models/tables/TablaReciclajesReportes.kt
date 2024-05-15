package com.example.models.tables

import org.jetbrains.exposed.dao.id.IntIdTable

object TablaReciclajesReportes: IntIdTable() {
    val reciclaje = reference("reciclaje", TablaReciclaje)
    val reporte = reference("reporte", TablaReporte)
}