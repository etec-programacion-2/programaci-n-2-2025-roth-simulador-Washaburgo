package org.example

class Partido(val equipoLocal: Equipo, val equipoVisitante: Equipo) {
    // Estado del partido
    var golesLocal = 0
        private set
    var golesVisitante = 0
        private set
    var minuto = 0
        private set
    val eventos = mutableListOf<String>()

    fun simular() {

        golesLocal = 0
        golesVisitante = 0
        minuto = 0
        eventos.clear()

        while (minuto < 90) {
            minuto++
            eventos.add("Minuto $minuto: Partido en desarrollo")
        }

        eventos.add("¡Partido finalizado! Marcador: $golesLocal - $golesVisitante")
    }

}