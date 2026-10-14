package org.example

fun main() {

    println("---- Primera llamada ----")
    CoffeeMachine.gestorEstados(Cafe.CAFE_LECHE,7.0)

    println("---- Segunda llamada ----")
    CoffeeMachine.gestorEstados(Cafe.CAFE_LECHE,7.0)

    println("---- Tercera llamada ----")
    CoffeeMachine.gestorEstados(Cafe.CAFE_LECHE,7.0)

}
