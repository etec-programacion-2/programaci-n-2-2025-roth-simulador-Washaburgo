package org.example

fun main() {
    // Crear equipos
    val barcelona = Equipo("FC Barcelona", "España")
    val realMadrid = Equipo("Real Madrid", "España")


    val pedri = Jugador("Pedri", Posicion.MEDIOCAMPISTA, Habilidades(90, 92, 87))
    val yamal = Jugador("Lamine Yamal", Posicion.DELANTERO, Habilidades(88, 75, 93)) // 边锋归为前锋
    val kounde = Jugador("Jules Koundé", Posicion.DEFENSOR, Habilidades(85, 80, 78))
    val raphinha = Jugador("Raphinha", Posicion.DELANTERO, Habilidades(84, 79, 89)) // 边锋归为前锋
    val olmo = Jugador("Dani Olmo", Posicion.MEDIOCAMPISTA, Habilidades(83, 86, 75))
    val kubasi = Jugador("Pau Cubarsí", Posicion.DEFENSOR, Habilidades(82, 76, 79))
    val balde = Jugador("Alejandro Balde", Posicion.DEFENSOR, Habilidades(79, 84, 86)) // 边后卫归为后卫
    val gavi = Jugador("Gavi", Posicion.MEDIOCAMPISTA, Habilidades(81, 78, 83))
    val araujo = Jugador("Ronald Araujo", Posicion.DEFENSOR, Habilidades(86, 81, 77))
    val rashford = Jugador("Marcus Rashford", Posicion.DELANTERO, Habilidades(85, 73, 90)) // 边锋归为前锋
    val terStegen = Jugador("Marc-André ter Stegen", Posicion.ARQUERO, Habilidades(89, 40, 65))
    val tcourtois = Jugador("Thibaut Courtois", Posicion.ARQUERO, Habilidades(85, 45, 60))
    val dcarvajal = Jugador("Daniel Carvajal", Posicion.DEFENSOR, Habilidades(78, 82, 55))
    val militao = Jugador("Éder Militão", Posicion.DEFENSOR, Habilidades(86, 75, 68))
    val alaba = Jugador("David Alaba", Posicion.DEFENSOR, Habilidades(83, 72, 65))
    val mendy = Jugador("Ferland Mendy", Posicion.DEFENSOR, Habilidades(79, 77, 58))
    val bellingham = Jugador("Jude Bellingham", Posicion.MEDIOCAMPISTA, Habilidades(92, 76, 80))
    val camavinga = Jugador("Eduardo Camavinga", Posicion.MEDIOCAMPISTA, Habilidades(84, 80, 70))
    val valverde = Jugador("Federico Valverde", Posicion.MEDIOCAMPISTA, Habilidades(87, 83, 75))
    val mbappe = Jugador("Kylian Mbappé", Posicion.DELANTERO, Habilidades(93, 95, 88))
    val vjunior = Jugador("Vinícius Júnior", Posicion.DELANTERO, Habilidades(90, 94, 85))
    val rodrigo = Jugador("Rodrygo", Posicion.DELANTERO, Habilidades(88, 89, 82))

    // Añadir jugadores a los equipos
    barcelona.aniadirJugador(pedri)
    barcelona.aniadirJugador(yamal)
    barcelona.aniadirJugador(kounde)
    barcelona.aniadirJugador(raphinha)
    barcelona.aniadirJugador(olmo)
    barcelona.aniadirJugador(kubasi)
    barcelona.aniadirJugador(balde)
    barcelona.aniadirJugador(gavi)
    barcelona.aniadirJugador(araujo)
    barcelona.aniadirJugador(rashford)
    barcelona.aniadirJugador(terStegen)
    realMadrid.aniadirJugador(tcourtois)
    realMadrid.aniadirJugador(dcarvajal)
    realMadrid.aniadirJugador(militao)
    realMadrid.aniadirJugador(alaba)
    realMadrid.aniadirJugador(mendy)
    realMadrid.aniadirJugador(bellingham)
    realMadrid.aniadirJugador(camavinga)
    realMadrid.aniadirJugador(valverde)
    realMadrid.aniadirJugador(mbappe)
    realMadrid.aniadirJugador(vjunior)
    realMadrid.aniadirJugador(rodrigo)


    // Crear partido
    val partido = Partido(barcelona, realMadrid)

    // Simular partido
    partido.simular()

    // Mostrar resultados
    println("Resultado final: ${partido.equipoLocal.nombre} ${partido.golesLocal} - ${partido.golesVisitante} ${partido.equipoVisitante.nombre}")
    println("Eventos registrados:")
    partido.eventos.forEach { println(it) }
}