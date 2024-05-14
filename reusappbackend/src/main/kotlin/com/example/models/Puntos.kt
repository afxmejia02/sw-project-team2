package com.example.models
import com.example.models.enums.TipoMaterial
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlin.random.Random



@Serializable
class Puntos(
    var cantidad: Int,
    private var codigo: String,
    val usuario: Usuario,
    private val reciclaje: Reciclaje,
    @Contextual
    val recompensas: Recompensas
){

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
        val peso = reciclaje.peso
        val material: TipoMaterial = reciclaje.material
        val puntosPorKilogramo : Int = 2
        val puntosPorMaterial = mapOf(
            TipoMaterial.AMARILLO to 4,
            TipoMaterial.AZUL to 5,
            TipoMaterial.ROJO to 6,
            TipoMaterial.VERDE to 3,
            TipoMaterial.NARANJA to 2,
            TipoMaterial.GRIS to 1
        )
        val puntosPorPeso = peso*puntosPorKilogramo
        val puntosPorMaterialReciclado = puntosPorMaterial[material] ?: 0
        val total = puntosPorPeso*puntosPorMaterialReciclado
        return total.toInt()
    }

    init{
        cantidad += asignarPuntos()
    }

    private fun restarPuntos(): Int {
        if (recompensas.verificarPuntos()) {
            return recompensas.minPuntos
        } else {
            return 0
        }
    }

    init{
        cantidad -= restarPuntos()
    }





}

