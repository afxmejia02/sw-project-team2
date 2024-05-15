package com.example.models
import com.example.models.tables.TablaReciclaje
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID


class Reciclaje(id: EntityID<Int>): IntEntity(id){
    companion object : IntEntityClass<Reciclaje>(TablaReciclaje)
    var material by TablaReciclaje.material
    var peso by TablaReciclaje.peso
    var fecha by TablaReciclaje.fecha
    var usuario by Usuario referencedOn TablaReciclaje.usuario
}



