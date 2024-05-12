package com.example.models
import kotlinx.serialization.Serializable
import java.security.MessageDigest
import java.util.Base64

@Serializable
class Cuenta(
    val nombre: String,
    private var hashedPassword: String,
    private val correo: String,
    val usuario: Usuario
) {
    companion object {
        private const val SALT = "vhfdwjvnc"

        fun hashPassword(password: String): String {
            val saltedPassword = "$SALT$password"
            val sha256 = MessageDigest.getInstance("SHA-256")
            val hashBytes = sha256.digest(saltedPassword.toByteArray())
            return Base64.getEncoder().encodeToString(hashBytes)
        }
    }

    fun checkPassword(passwordInput: String): Boolean {
        val hashedInput = hashPassword(passwordInput)
        return hashedInput == hashedPassword
    }
}