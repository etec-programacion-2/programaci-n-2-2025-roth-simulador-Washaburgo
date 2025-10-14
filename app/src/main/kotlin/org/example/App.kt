package org.example

fun main() {
    // Crear equipos
    val barcelona = Equipo("FC Barcelona", "España")
    val realMadrid = Equipo("Real Madrid", "España")

    // Crear jugadores (simplificado para el ejemplo)
    val messi = Jugador("Lionel Messi", Posicion.DELANTERO, Habilidades(95, 45, 85))
    val neuer = Jugador("Manuel Neuer", Posicion.ARQUERO, Habilidades(10, 90, 60))
    val ronaldo = Jugador("Cristiano Ronaldo", Posicion.DELANTERO, Habilidades(90, 50, 90))
    val modric = Jugador("Luka Modric", Posicion.MEDIOCAMPISTA, Habilidades(80, 70, 75))

    // Añadir jugadores a los equipos
    barcelona.aniadirJugador(messi)
    barcelona.aniadirJugador(neuer)
    realMadrid.aniadirJugador(ronaldo)
    realMadrid.aniadirJugador(modric)

    // Crear partido
    val partido = Partido(barcelona, realMadrid)

    // Simular partido
    partido.simular()

    // Mostrar resultados
    println("Resultado final: ${partido.equipoLocal.nombre} ${partido.golesLocal} - ${partido.golesVisitante} ${partido.equipoVisitante.nombre}")
    println("Eventos registrados:")
    partido.eventos.forEach { println(it) }
}