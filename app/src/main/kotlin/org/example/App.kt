package org.example

import org.example.Posicion
import org.example.Habilidades
import org.example.Jugador

fun main() {
    val messi = Jugador(
        nombre = "Lionel Messi",
        posicion = Posicion.DELANTERO,
        habilidades = Habilidades(ataque = 95, defensa = 45, velocidad = 85)
    )

    val neuer = Jugador(
        nombre = "Manuel Neuer",
        posicion = Posicion.ARQUERO,
        habilidades = Habilidades(ataque = 10, defensa = 90, velocidad = 60)
    )

    println("Equipo de Fútbol Simulador")
    println("------------------------------")
    println("Jugador 1: ${messi.nombre} (${messi.posicion})")
    println("  Ataque: ${messi.habilidades.ataque}")
    println("  Defensa: ${messi.habilidades.defensa}")
    println("  Velocidad: ${messi.habilidades.velocidad}")

    println("\nJugador 2: ${neuer.nombre} (${neuer.posicion})")
    println("  Ataque: ${neuer.habilidades.ataque}")
    println("  Defensa: ${neuer.habilidades.defensa}")
    println("  Velocidad: ${neuer.habilidades.velocidad}")
}