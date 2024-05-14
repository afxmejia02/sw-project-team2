package com.example.models

import com.example.models.enums.TipoMaterial
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
class Usuario(
    val nombre: String,
    val apellido: String,
    protected val cedula: Int,
    protected val telefono: Int,
    @Contextual
    private val fechaRegistro:LocalDate,
    val cuenta: Cuenta,
    val direccion: Direccion,
    val reciclajes: MutableList<Reciclaje> = mutableListOf(),
    @Contextual
    val puntos: Puntos,
    @Contextual
    val recompense: UsuariosRecompensas,
    private var recompensas: MutableList<Recompensas> = mutableListOf(),

    ) {
    fun agregarReciclaje(reciclaje: Reciclaje): MutableList<Reciclaje> {
        reciclajes.add(reciclaje)
        reciclaje.usuario = this
        return reciclajes
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

    fun agregarRecompensas(recompensas: List<Recompensas>) {
        for (r in recompensas) {
            if (this.recompense.puntosRecompensas.verificarPuntos() && !this.recompensas.contains(r)) {
                this.recompensas.add(r)
            }
        }

    }







}