package com.example.models
import com.example.models.tables.TablaPuntosRecompensas
import com.example.models.tables.TablaRecompensas
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID


class Recompensas (id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<Recompensas>(TablaRecompensas)

    var nombre by TablaRecompensas.nombre
    var minPuntos by TablaRecompensas.minPuntos
    var descripcion by TablaRecompensas.descripcion
    var punto by Puntos referencedOn TablaPuntosRecompensas.punto

    fun verificarPuntos(): Boolean{
        return punto.cantidad >= minPuntos
    }

    fun restarPuntos(): Int {
        return if (verificarPuntos()) {
            minPuntos
        } else {
            0
        }
    }

}


