package org.example

import kotlin.text.compareTo

class Equipo(val nombre: String, val pais: String) {

    private val jugadores = mutableListOf<Jugador>()

    companion object {

        const val LIMITE_JUGADORES = 11

    }

    fun aniadirJugador(jugador: Jugador): Boolean {

        if (jugadores.size < LIMITE_JUGADORES) {

            jugadores.add(jugador)

            return true

        }

        return false

    }

    fun obtenerPlantilla(): List<Jugador> {

        return jugadores.toList()

    }

    fun obtenerNumeroJugadores(): Int {

        return jugadores.size

    }

    // Calcula el nivel promedio de ataque (solo delanteros)
    fun calcularNivelAtaque(): Double {
        val delanteros = jugadores.filter { it.posicion == Posicion.DELANTERO }
        return if (delanteros.isNotEmpty()) {
            delanteros.map { it.habilidades.ataque.toDouble() }.average()
        } else 0.0
    }

    // Calcula el nivel promedio de defensa (defensores + arquero)
    fun calcularNivelDefensa(): Double {
        val defensores = jugadores.filter { it.posicion == Posicion.DEFENSOR }
        val arquero = jugadores.firstOrNull { it.posicion == Posicion.ARQUERO }
        val totalDefensas = defensores.size + if (arquero != null) 1 else 0
        val sumaDefensas = defensores.sumByDouble { it.habilidades.defensa.toDouble() } +
                (arquero?.habilidades?.defensa?.toDouble() ?: 0.0)
        return if (totalDefensas > 0) sumaDefensas / totalDefensas else 0.0
    }

    // Calcula el nivel promedio de mediocampo (mediocampistas)
    fun calcularNivelMediocampo(): Double {
        val mediocampistas = jugadores.filter { it.posicion == Posicion.MEDIOCAMPISTA }
        return if (mediocampistas.isNotEmpty()) {
            mediocampistas.map { it.habilidades.velocidad.toDouble() }.average()
        } else 0.0
    }
}
