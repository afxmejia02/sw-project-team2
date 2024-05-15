package com.example.models
import com.example.models.tables.TablaDireccion
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID


class Direccion(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<Direccion>(TablaDireccion)


    var tipoVia by TablaDireccion.tipoVia
    var numeroVia by TablaDireccion.numeroVia
    var complemento by TablaDireccion.complemento
    var barrio by TablaDireccion.barrio
    var comuna by TablaDireccion.comuna
    var codigoPostal by TablaDireccion.codigoPostal
}
