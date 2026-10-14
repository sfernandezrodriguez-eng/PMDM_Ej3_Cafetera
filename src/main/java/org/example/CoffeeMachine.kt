package org.example

import CoffeeMachineState
import CoffeeMachineState.*

/**
 * Singleton que maneja lo que ocurre en cada estado
 */
object CoffeeMachine {
    public var currentState: CoffeeMachineState = CoffeeMachineState.Idle()

    fun gestorEstados() {
        println("Estado actual: $currentState")

        when (currentState) {
            is CoffeeMachineState.Idle -> {
                val idleState = currentState as CoffeeMachineState.SelectCoffee
                println("Bienvenido, quiere hacer un cafe? Si o no")
               var a = true
                Thread.sleep(2000)
                if (a == false) {
                    println("Ok, apagando maquina....")
                    val idleState = currentState as CoffeeMachineState.Apagado
                    Thread.sleep(2000)
                }
                else if (a == true) {
                    println("Pasando a seleccion de café...")
                    Thread.sleep(2000)
                }
                else{
                    println("Error, no has seleccionado una de la opciones....")
                    val idleState = currentState as CoffeeMachineState.Error
                    Thread.sleep(2000)
                }
            }



            is CoffeeMachineState.SelectCoffee -> {
                val idleState = currentState as CoffeeMachineState.PaymentCoffee
                println("Seleccionando cafe...")

            }
            is CoffeeMachineState.PaymentCoffee -> {

                val idleState = currentState as CoffeeMachineState.MakingCoffee
                println("Paga el café.")
                Thread.sleep(2000)
                // Simula un proceso de preparación
                currentState = MakingCoffee(type = "Nescafé")
                println("¡Café listo! Estado: $currentState")

            }
            is CoffeeMachineState.MakingCoffee -> {
                val idleState = currentState as CoffeeMachineState.ServingCoffee
                println("¡Espera! La máquina ya está haciendo café.")
            }
            is CoffeeMachineState.ServingCoffee -> {
                val idleState = currentState as CoffeeMachineState.Idle
                println("Ya hay café servido. Por favor, toma tu café.")
            }
            is CoffeeMachineState.Error -> {
                println("La máquina tiene un error:")
            }

            is CoffeeMachineState.Apagado -> {

                val idleState = currentState as CoffeeMachineState.Idle
                println("Máquina encendida desde:  Empezando a hacer café...")
                Thread.sleep(2000)

            }

            CoffeeMachineState.Inicio -> TODO()
        }
    }
}