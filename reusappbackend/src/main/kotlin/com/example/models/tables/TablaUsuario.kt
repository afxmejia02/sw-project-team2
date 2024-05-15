package com.example.models.tables
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.javatime.date
import java.time.LocalDate

object TablaUsuario: IntIdTable(){
    val nombre: Column<String> = varchar("nombre", 50)
    val apellido: Column<String> = varchar("apellido", 50)
    val cedula: Column<Int> = integer("cedula")
    val telefono: Column<Int> = integer("telefono")
    val fechaRegistro: Column<LocalDate> = date("fechaRegistro")
    val cuenta = reference("cuenta", TablaCuenta.id, onDelete = ReferenceOption.CASCADE)
    val direccion = reference("direccion", TablaDireccion.id)
    val puntos = reference("puntos", TablaPuntos.id, onDelete = ReferenceOption.CASCADE)
    val usuariosRecompensas = reference("UsuariosRecompensas", TablaUsuariosRecompensas.id, onDelete = ReferenceOption.CASCADE)
    val reciclajes = reference("reciclajes", TablaReciclaje.id).nullable()
    //val recompensas = reference("recompensas", TablaRecompensas.id).nullable()
}