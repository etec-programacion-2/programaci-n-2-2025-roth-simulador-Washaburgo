package org.example

import Posicion
import Habilidades
import Jugador

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

    val rasmussen = Jugador(
        nombre = "Federico Rasmussen",
        posicion = Posicion.DEFENSA,
        habilidades = Habilidades(ataque = 38, defensa = 65, velocidad = 40)
    )

    // Mostrar información de los jugadores
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