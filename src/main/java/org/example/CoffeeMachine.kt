package org.example

import CoffeeMachineState

/**
 * Singleton que maneja lo que ocurre en cada estado
 */
object CoffeeMachine {
    public var currentState: CoffeeMachineState = CoffeeMachineState.Idle()

    fun gestorEstados() {
        println("Estado actual: $currentState")

        when (currentState) {
            is CoffeeMachineState.Idle -> {

                val idleState = currentState as CoffeeMachineState.Idle
                println("Máquina encendida desde: ${idleState.timestamp}. Empezando a hacer café...")
                Thread.sleep(2000)
                // Simula un proceso de preparación
                currentState = CoffeeMachineState.MakingCoffee(type = "Nescafé")
                println("¡Café listo! Estado: $currentState")
            }
            is CoffeeMachineState.MakingCoffee -> {
                val idleState = currentState as CoffeeMachineState.Idle
                println("¡Espera! La máquina ya está haciendo café.")
            }
            is CoffeeMachineState.ServingCoffee -> {
                val idleState = currentState as CoffeeMachineState.Idle
                println("Ya hay café servido. Por favor, toma tu café.")
            }
            is CoffeeMachineState.Error -> {
                println("La máquina tiene un error:")
            }
            is CoffeeMachineState.PaymentCoffee -> {

                val idleState = currentState as CoffeeMachineState.Idle
                println("Máquina encendida desde: ${idleState.timestamp}. Empezando a hacer café...")
                Thread.sleep(2000)
                // Simula un proceso de preparación
                currentState = CoffeeMachineState.MakingCoffee(type = "Nescafé")
                println("¡Café listo! Estado: $currentState")
            }


            is CoffeeMachineState.Apagado -> {

                val idleState = currentState as CoffeeMachineState.Idle
                println("Máquina encendida desde: ${idleState.timestamp}. Empezando a hacer café...")
                Thread.sleep(2000)
                // Simula un proceso de preparación
                currentState = CoffeeMachineState.MakingCoffee(type = "Nescafé")
                println("¡Café listo! Estado: $currentState")
            }

        }
    }

    fun clean() {
        // Implementación de clean
    }
}