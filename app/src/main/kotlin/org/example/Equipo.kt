package org.example

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

}