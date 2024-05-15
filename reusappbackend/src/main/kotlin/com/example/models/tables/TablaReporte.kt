package com.example.models.tables

import com.example.models.enums.Periodicidad
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object TablaReporte: IntIdTable() {
    val periodicidad: Column<Periodicidad> = enumerationByName("periodicidad", 20, Periodicidad::class)
}
