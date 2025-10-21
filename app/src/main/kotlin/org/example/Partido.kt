package org.example

import kotlin.random.Random

class Partido(val equipoLocal: Equipo, val equipoVisitante: Equipo) {

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

        // Calcular ventaja general considerando todos los aspectos
        val ventajaLocal = calcularVentajaLocal()

        while (minuto < 90) {
            minuto++

            // Determinar qué equipo ataca basado en la posesión
            val posesionLocal = Random.nextDouble() < ventajaLocal

            if (posesionLocal) {
                simularAtaqueLocal()
            } else {
                simularAtaqueVisitante()
            }
        }

        eventos.add("¡Partido finalizado! ${equipoLocal.nombre} $golesLocal - $golesVisitante ${equipoVisitante.nombre}")
    }

    private fun calcularVentajaLocal(): Double {
        val nivelTotalLocal = equipoLocal.calcularNivelAtaque() +
                equipoLocal.calcularNivelMediocampo() +
                equipoLocal.calcularNivelDefensa()

        val nivelTotalVisitante = equipoVisitante.calcularNivelAtaque() +
                equipoVisitante.calcularNivelMediocampo() +
                equipoVisitante.calcularNivelDefensa()

        // Ventaja local del 55% + diferencia de nivel (máximo 10% adicional)
        val ventajaBase = 0.55
        val ventajaNivel = (nivelTotalLocal - nivelTotalVisitante) * 0.001
        return (ventajaBase + ventajaNivel).coerceIn(0.45, 0.65)
    }

    private fun simularAtaqueLocal() {
        // Solo el 20% de las posesiones resultan en oportunidades claras
        if (Random.nextDouble() < 0.2) {
            val probabilidadGol = calcularProbabilidadGol(
                equipoLocal.calcularNivelAtaque(),
                equipoVisitante.calcularNivelDefensa()
            )

            if (Random.nextDouble() < probabilidadGol) {
                golesLocal++
                eventos.add("Minuto $minuto: ¡GOL del ${equipoLocal.nombre}!")
            } else {
                if (Random.nextDouble() < 0.3) {
                    eventos.add("Minuto $minuto: Oportunidad clara del ${equipoLocal.nombre} pero falla")
                }
            }
        }
    }

    private fun simularAtaqueVisitante() {
        // Solo el 20% de las posesiones resultan en oportunidades claras
        if (Random.nextDouble() < 0.2) {
            val probabilidadGol = calcularProbabilidadGol(
                equipoVisitante.calcularNivelAtaque(),
                equipoLocal.calcularNivelDefensa()
            )

            if (Random.nextDouble() < probabilidadGol) {
                golesVisitante++
                eventos.add("Minuto $minuto: ¡GOL del ${equipoVisitante.nombre}!")
            } else {
                if (Random.nextDouble() < 0.3) {
                    eventos.add("Minuto $minuto: Oportunidad clara del ${equipoVisitante.nombre} pero falla")
                }
            }
        }
    }

    private fun calcularProbabilidadGol(ataque: Double, defensa: Double): Double {
        // Probabilidad base más baja y más realista
        val probBase = 0.15

        // Ajuste basado en la relación ataque/defensa
        val ajusteNivel = (ataque - defensa) * 0.002

        return (probBase + ajusteNivel).coerceIn(0.05, 0.35)
    }
}