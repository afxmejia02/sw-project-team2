package com.example.models

import com.example.models.tables.TablaCuenta
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.security.MessageDigest
import java.util.Base64


class Cuenta(id: EntityID<Int>) : IntEntity(id) {



    var nombre by TablaCuenta.nombre
    private var hashedPassword by TablaCuenta.hashedPassword
    var correo by TablaCuenta.correo
    var usuario by Usuario referencedOn TablaCuenta.usuarioId

    fun actualizarNombre(nuevoNombre: String) {
        nombre = nuevoNombre
    }

    companion object : IntEntityClass<Cuenta>(TablaCuenta) {
        private const val SALT = "vhfdwjvnc"

        fun hashPassword(password: String): String {
            val saltedPassword = "$SALT$password"
            val sha256 = MessageDigest.getInstance("SHA-256")
            val hashBytes = sha256.digest(saltedPassword.toByteArray())
            return Base64.getEncoder().encodeToString(hashBytes)
        }
        fun verificarSeguridadContrasena(password: String): Boolean {
            // Verificar longitud mínima
            if (password.length < 8) {
                return false
            }

            // Verificar caracteres especiales
            val caracteresEspeciales = "!@#$%^&*()_-+=<>,.?/\\|{}[]~"
            val contieneCaracterEspecial = password.any { it in caracteresEspeciales }
            if (!contieneCaracterEspecial) {
                return false
            }

            // Verificar números
            val contieneNumero = password.any { it.isDigit() }
            if (!contieneNumero) {
                return false
            }

            // Verificar letras mayúsculas y minúsculas
            val contieneMayuscula = password.any { it.isUpperCase() }
            val contieneMinuscula = password.any { it.isLowerCase() }
            if (!contieneMayuscula || !contieneMinuscula) {
                return false
            }

            //Cumple con los requisitos entonces
            return true
        }


    }

    fun checkPassword(passwordInput: String): Boolean {
        val hashedInput = hashPassword(passwordInput)
        return hashedInput == hashedPassword
    }
}