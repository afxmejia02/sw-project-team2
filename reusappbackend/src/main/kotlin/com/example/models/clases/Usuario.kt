package com.example.models


import com.example.models.enums.TipoMaterial
import com.example.models.tables.TablaReciclaje
import com.example.models.tables.TablaUsuario
import com.example.models.tables.TablaUsuariosRecompensas
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.SizedIterable

/*val nombre: String,
 val apellido: String,
 protected val cedula: Int,
 protected val telefono: Int,
 @Contextual
 private val fechaRegistro:LocalDate,
 val cuenta: Cuenta,
 val direccion: Direccion,
 private val reciclajes: MutableList<Reciclaje> = mutableListOf(),
 @Contextual
 val puntos: Puntos,
 @Contextual
 val recompense: UsuariosRecompensas,
 private var recompensas: MutableList<Recompensas> = mutableListOf(),
 */

class Usuario(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<Usuario>(TablaUsuario)

    var nombre by TablaUsuario.nombre
    var apellido by TablaUsuario.apellido
    var cedula by TablaUsuario.cedula
    var telefono by TablaUsuario.telefono
    var fechaRegistro by TablaUsuario.fechaRegistro
    var cuenta by Cuenta referencedOn TablaUsuario.cuenta
    var direccion by Direccion referencedOn TablaUsuario.direccion
    var puntos by Puntos referencedOn TablaUsuario.puntos
    val reciclajes by Reciclaje referrersOn TablaReciclaje.usuario
    private val recompensas: SizedIterable<Recompensas> by Recompensas via TablaUsuariosRecompensas


    fun obtenerReciclajes(): List<Reciclaje> {
        return reciclajes.toList()
    }

    fun obtenerRecompensas(): List<Recompensas> {
        return recompensas.toList()
    }



    fun calcularPesoTotalPorMaterial(reciclajes: List<Reciclaje>): Pair<Double, Map<TipoMaterial, Double>> {
        val pesoPorMaterial: MutableMap<TipoMaterial, Double> = mutableMapOf()
        var pesoTotal = 0.0
        for (reciclaje in reciclajes) {

            val pesoExistente = pesoPorMaterial.getOrDefault(reciclaje.material, 0.0)
            pesoPorMaterial[reciclaje.material] = pesoExistente + reciclaje.peso
            pesoTotal += reciclaje.peso
        }
        return Pair(pesoTotal, pesoPorMaterial)
    }
}










