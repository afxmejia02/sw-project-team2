package com.example.models
import com.example.models.enums.*
import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters

@Serializable
class Reporte(
    val periodicidad: Periodicidad,
    private val reciclaje: Reciclaje
) {
    fun generarReportes(
        reciclajes: List<Reciclaje>,
        fecha: LocalDate,
        periodicidad: Periodicidad
    ): List<Reporte> {
        return when (periodicidad) {
            Periodicidad.DIARIO -> generarReportesDiarios(reciclajes, fecha)
            Periodicidad.SEMANAL -> generarReportesSemanal(reciclajes, fecha)
            Periodicidad.MENSUAL -> generarReportesMensuales(reciclajes, fecha)
            Periodicidad.ANUAL -> generarReportesAnuales(reciclajes, fecha)
        }
    }

    private fun generarReportesDiarios(
        reciclajes: List<Reciclaje>,
        fecha: LocalDate
    ): List<Reporte> {
        val reciclajesDelDia = reciclajes.filter { it.fecha == fecha }
        return listOf(crearReporte(reciclajesDelDia))
    }

    private fun generarReportesSemanal(
        reciclajes: List<Reciclaje>,
        fecha: LocalDate
    ): List<Reporte> {
        val primerDiaDeLaSemana =
            fecha.with(TemporalAdjusters.previousOrSame(LocalDate.now().dayOfWeek))
        val ultimoDiaDeLaSemana = primerDiaDeLaSemana.plusDays(6)
        val reciclajesDeLaSemana =
            reciclajes.filter { it.fecha in primerDiaDeLaSemana..ultimoDiaDeLaSemana }
        return listOf(crearReporte(reciclajesDeLaSemana))
    }

    private fun generarReportesMensuales(
        reciclajes: List<Reciclaje>,
        fecha: LocalDate
    ): List<Reporte> {
        val primerDiaDelMes = fecha.with(TemporalAdjusters.firstDayOfMonth())
        val ultimoDiaDelMes = fecha.with(TemporalAdjusters.lastDayOfMonth())
        val reciclajesDelMes = reciclajes.filter { it.fecha in primerDiaDelMes..ultimoDiaDelMes }
        return listOf(crearReporte(reciclajesDelMes))
    }

    private fun generarReportesAnuales(
        reciclajes: List<Reciclaje>,
        fecha: LocalDate
    ): List<Reporte> {
        val primerDiaDelAnio = fecha.with(TemporalAdjusters.firstDayOfYear())
        val ultimoDiaDelAnio = fecha.with(TemporalAdjusters.lastDayOfYear())
        val reciclajesDelAnio = reciclajes.filter { it.fecha in primerDiaDelAnio..ultimoDiaDelAnio }
        return listOf(crearReporte(reciclajesDelAnio))
    }

    private fun crearReporte(reciclajes: List<Reciclaje>): Reporte {
        val pesoPorMaterial: MutableMap<TipoMaterial, Double> = mutableMapOf()
        var pesoTotal = 0.0
        for (reciclaje in reciclajes) {
            val pesoExistente = pesoPorMaterial.getOrDefault(reciclaje.material, 0.0)
            pesoPorMaterial[reciclaje.material] = pesoExistente + reciclaje.peso
            pesoTotal += reciclaje.peso
        }
        return Reporte(periodicidad, reciclaje)
    }
}