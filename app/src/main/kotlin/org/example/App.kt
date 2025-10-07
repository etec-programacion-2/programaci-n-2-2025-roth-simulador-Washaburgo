package org.example

fun main() {
    // Crear jugadores
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

    // Crear equipo
    val godoycruz = Equipo("Godoy Cruz", "Argentina")

    // Añadir jugadores al equipo
    godoycruz.aniadirJugador(messi)
    godoycruz.aniadirJugador(neuer)

    // Mostrar información del equipo
    println("Equipo: ${godoycruz.nombre} (${godoycruz.pais})")
    println("Número de jugadores: ${godoycruz.obtenerNumeroJugadores()}")
    println("\nPlantilla:")
    godoycruz.obtenerPlantilla().forEach { jugador ->
        println("- ${jugador.nombre} (${jugador.posicion})")
    }
}