package com.example.models.tables

import com.example.models.enums.TipoMaterial
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.javatime.date
import java.time.LocalDate

object TablaReciclaje: IntIdTable() {
    val material: Column<TipoMaterial> = enumerationByName("tipo_material", 20, TipoMaterial::class)
    val peso: Column<Double> = double("peso")
    val fecha: Column<LocalDate> = date("fecha")
    val usuario = reference("usuario", TablaUsuario.id)
}