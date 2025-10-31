package org.example

class SimuladorTorneo(private val equipos: List<Equipo>) {
    private val estadisticasEquipos = mutableMapOf<String, EstadisticasEquipo>()

    init {
        equipos.forEach { equipo ->
            estadisticasEquipos[equipo.nombre] = EstadisticasEquipo()
        }
    }

    fun simularTorneo(): Map<String, EstadisticasEquipo> {
        println("=== INICIO DEL TORNEO ===")
        println("Equipos participantes: ${equipos.joinToString { it.nombre }}")
        println()

        // Fase de ida
        simularFaseRoundRobin("Fase de Ida", esVuelta = false)

        // Fase de vuelta
        simularFaseRoundRobin("Fase de Vuelta", esVuelta = true)

        mostrarTablaFinal()
        return estadisticasEquipos.toMap()
    }

    private fun simularFaseRoundRobin(nombreFase: String, esVuelta: Boolean) {
        println("=== $nombreFase ===")

        val equiposRotativos = equipos.toMutableList()

        // Si el número de equipos es impar, agregar un "descanso"
        if (equiposRotativos.size % 2 != 0) {
            equiposRotativos.add(Equipo("DESCANSO", ""))
        }

        val numEquipos = equiposRotativos.size
        val numFechas = numEquipos - 1

        for (fecha in 0 until numFechas) {
            val partidosFecha = mutableListOf<String>()

            // Generar los partidos de esta fecha
            for (i in 0 until numEquipos / 2) {
                val equipo1 = equiposRotativos[i]
                val equipo2 = equiposRotativos[numEquipos - 1 - i]

                // Saltar si alguno es "DESCANSO"
                if (equipo1.nombre != "DESCANSO" && equipo2.nombre != "DESCANSO") {
                    val local = if (esVuelta) equipo2 else equipo1
                    val visitante = if (esVuelta) equipo1 else equipo2

                    // Simular partido
                    val partido = Partido(local, visitante)
                    partido.simular()

                    // Registrar resultado y estadísticas
                    registrarEstadisticas(partido)

                    // Agregar partido a la fecha
                    partidosFecha.add("${local.nombre} ${partido.golesLocal}-${partido.golesVisitante} ${visitante.nombre}")
                }
            }

            // Rotar equipos (excepto el primero)
            val ultimo = equiposRotativos.removeAt(equiposRotativos.size - 1)
            equiposRotativos.add(1, ultimo)
        }

        println()
    }

    private fun registrarEstadisticas(partido: Partido) {
        val estadisticasLocal = estadisticasEquipos[partido.equipoLocal.nombre]!!
        val estadisticasVisitante = estadisticasEquipos[partido.equipoVisitante.nombre]!!

        // Actualizar partidos jugados
        estadisticasLocal.partidosJugados++
        estadisticasVisitante.partidosJugados++

        // Actualizar goles
        estadisticasLocal.golesFavor += partido.golesLocal
        estadisticasLocal.golesContra += partido.golesVisitante
        estadisticasVisitante.golesFavor += partido.golesVisitante
        estadisticasVisitante.golesContra += partido.golesLocal

        // Actualizar resultados y puntos
        when {
            partido.golesLocal > partido.golesVisitante -> {
                estadisticasLocal.victorias++
                estadisticasLocal.puntos += 3
                estadisticasVisitante.derrotas++
            }
            partido.golesLocal < partido.golesVisitante -> {
                estadisticasVisitante.victorias++
                estadisticasVisitante.puntos += 3
                estadisticasLocal.derrotas++
            }
            else -> {
                estadisticasLocal.empates++
                estadisticasLocal.puntos += 1
                estadisticasVisitante.empates++
                estadisticasVisitante.puntos += 1
            }
        }
    }

    private fun mostrarTablaFinal() {
        println("=== TABLA FINAL DE POSICIONES ===")

        val tablaOrdenada = obtenerTablaOrdenada()

        println("Pos. Equipo                    PJ   V   E   D   GF  GC  DIF  Pts")
        println("-".repeat(70))

        tablaOrdenada.forEachIndexed { index, (equipo, stats) ->
            val posicion = (index + 1).toString().padEnd(4)
            val nombreEquipo = equipo.padEnd(25)
            val pj = stats.partidosJugados.toString().padStart(3)
            val v = stats.victorias.toString().padStart(3)
            val e = stats.empates.toString().padStart(3)
            val d = stats.derrotas.toString().padStart(3)
            val gf = stats.golesFavor.toString().padStart(3)
            val gc = stats.golesContra.toString().padStart(3)
            val dif = stats.diferenciaGoles.toString().padStart(4)
            val pts = stats.puntos.toString().padStart(3)

            println("$posicion$nombreEquipo $pj  $v  $e  $d  $gf  $gc  $dif  $pts")
        }
        println()
    }

    private fun obtenerTablaOrdenada(): List<Pair<String, EstadisticasEquipo>> {
        return estadisticasEquipos.entries
            .sortedWith(compareByDescending<Map.Entry<String, EstadisticasEquipo>> { it.value.puntos }
                .thenByDescending { it.value.diferenciaGoles }
                .thenByDescending { it.value.golesFavor }
                .thenBy { it.key } // Orden alfabético como último criterio
            )
            .map { it.key to it.value }
    }

    fun obtenerTablaPosiciones(): Map<String, EstadisticasEquipo> {
        return estadisticasEquipos.toMap()
    }

    fun obtenerPartidosPorFecha(): List<List<String>> {
        // Para simplificar, retornamos lista vacía ya que el enfoque está en la tabla
        return emptyList()
    }
}

// NUEVA CLASE PARA ESTADÍSTICAS
data class EstadisticasEquipo(
    var partidosJugados: Int = 0,
    var victorias: Int = 0,
    var empates: Int = 0,
    var derrotas: Int = 0,
    var golesFavor: Int = 0,
    var golesContra: Int = 0,
    var puntos: Int = 0
) {
    val diferenciaGoles: Int
        get() = golesFavor - golesContra
}