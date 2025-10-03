package org.example

import org.example.Posicion
import org.example.Habilidades

data class Jugador(
    val nombre: String,
    val posicion: Posicion,
    val habilidades: Habilidades
)