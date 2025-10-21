package org.example

class SimuladorTorneo(private val equipos: List<Equipo>) {
    private val tablaPosiciones = mutableMapOf<String, Int>()
    private val partidosJugados = mutableListOf<String>()

    init {
        // Inicializar tabla de posiciones
        equipos.forEach { equipo ->
            tablaPosiciones[equipo.nombre] = 0
        }
    }

    fun simularTorneo(): Map<String, Int> {
        println("Torneo en Progreso")
        println("Equipos participantes: ${equipos.joinToString { it.nombre }}")
        println()

        // Fase de ida
        simularFase("Fase de Ida")

        // Fase de vuelta
        simularFase("Fase de Vuelta")

        mostrarTablaFinal()
        return tablaPosiciones.toMap()
    }

    private fun simularFase(nombreFase: String) {
        println("=== $nombreFase ===")

        for (i in equipos.indices) {
            for (j in i + 1 until equipos.size) {
                val equipoLocal = equipos[i]
                val equipoVisitante = equipos[j]

                // Simular partido
                val partido = Partido(equipoLocal, equipoVisitante)
                partido.simular()

                // Registrar resultado y actualizar puntos
                registrarResultado(partido)

                // Mostrar resultado
                println("${equipoLocal.nombre} ${partido.golesLocal} - ${partido.golesVisitante} ${equipoVisitante.nombre}")
            }
        }
        println()
    }

    private fun registrarResultado(partido: Partido) {
        val puntosLocal: Int
        val puntosVisitante: Int

        when {
            partido.golesLocal > partido.golesVisitante -> {
                puntosLocal = 3
                puntosVisitante = 0
            }
            partido.golesLocal < partido.golesVisitante -> {
                puntosLocal = 0
                puntosVisitante = 3
            }
            else -> {
                puntosLocal = 1
                puntosVisitante = 1
            }
        }

        // Actualizar tabla de posiciones
        tablaPosiciones[partido.equipoLocal.nombre] =
            tablaPosiciones[partido.equipoLocal.nombre]!! + puntosLocal
        tablaPosiciones[partido.equipoVisitante.nombre] =
            tablaPosiciones[partido.equipoVisitante.nombre]!! + puntosVisitante

        // Guardar registro del partido
        partidosJugados.add(
            "${partido.equipoLocal.nombre} ${partido.golesLocal}-${partido.golesVisitante} ${partido.equipoVisitante.nombre}"
        )
    }

    private fun mostrarTablaFinal() {
        println("=== TABLA FINAL DE POSICIONES ===")

        val tablaOrdenada = tablaPosiciones.entries.sortedByDescending { it.value }

        tablaOrdenada.forEachIndexed { index, entry ->
            println("${index + 1}. ${entry.key} - ${entry.value} puntos")
        }
    }

    fun obtenerTablaPosiciones(): Map<String, Int> {
        return tablaPosiciones.toMap()
    }

    fun obtenerPartidosJugados(): List<String> {
        return partidosJugados.toList()
    }
}