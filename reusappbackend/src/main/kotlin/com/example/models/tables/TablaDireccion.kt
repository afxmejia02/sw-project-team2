package com.example.models.tables

import com.example.models.enums.TipoVia
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object TablaDireccion: IntIdTable(){
    val tipoVia: Column<TipoVia> = enumerationByName("TipoVia", 20, TipoVia::class)
    val numeroVia: Column<Int> = integer("NumeroVia") //#XX-XX
    val complemento = varchar("complemento", 200) // Apartamento, unidad, edificio, etc.
    val barrio = varchar("barrio", 50)
    val comuna = integer("comuna")
    val codigoPostal: Column<Int>  = integer("codigo_postal")
}