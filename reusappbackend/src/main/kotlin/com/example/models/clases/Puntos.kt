package com.example.models

import com.example.models.enums.TipoMaterial
import com.example.models.tables.TablaPuntos
import com.example.models.tables.TablaPuntosRecompensas
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import kotlin.random.Random


class Puntos(id: EntityID<Int>): IntEntity(id){

    companion object : IntEntityClass<Puntos>(TablaPuntos)

    var cantidad by TablaPuntos.cantidad
    private var codigo by TablaPuntos.codigo
    val usuario by Usuario referencedOn TablaPuntos.usuario
    var recompensa by Recompensas referencedOn TablaPuntosRecompensas.recompensa


    fun randomCode(): String{
        val caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        val longitud = 10
        val codigo = StringBuilder(longitud)

        for (i in 0 until longitud) {
            val indice = Random.nextInt(caracteres.length)
            codigo.append(caracteres[indice])
        }
        return codigo.toString()
    }

    init {
       codigo = randomCode()
    }

    init {
        cantidad=0
    }

    fun asignarPuntos(): Int{
         var pesoTotal = 0.0
         val materialesReciclados = mutableListOf<TipoMaterial>()
        for (reciclaje in usuario.reciclajes) {
            pesoTotal += reciclaje.peso
            materialesReciclados.add(reciclaje.material)
        }
            val puntosPorKilogramo: Int = 2
            val puntosPorMaterial = mapOf(
                TipoMaterial.AMARILLO to 4,
                TipoMaterial.AZUL to 5,
                TipoMaterial.ROJO to 6,
                TipoMaterial.VERDE to 3,
                TipoMaterial.NARANJA to 2,
                TipoMaterial.GRIS to 1
            )
            val puntosPorPeso = pesoTotal * puntosPorKilogramo
            val puntosPorMaterialReciclado = materialesReciclados.sumBy { puntosPorMaterial[it] ?: 0 }
            val total = puntosPorPeso * puntosPorMaterialReciclado
            return total.toInt()
        }


    init{
        cantidad += asignarPuntos()
    }

    init{
        cantidad -= recompensa.restarPuntos()
    }

}

