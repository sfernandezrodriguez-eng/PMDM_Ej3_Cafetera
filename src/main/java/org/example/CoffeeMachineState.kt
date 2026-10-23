package org.example

import org.example.CoffeeMachine.currentState
import org.example.CoffeeMachine.monedero
import org.example.CoffeeMachine.nombreCafe
import org.example.CoffeeMachine.quieres

sealed class CoffeeMachineState {
    object Idle : CoffeeMachineState(){
        fun onEnter(){
            currentState = SelectCoffee(type = nombreCafe)
            println("Bienvenido, quiere hacer un cafe? Si o no")
            Thread.sleep(2000)
            if (!quieres) {
                println("Ok, apagando maquina....")
                currentState = Apagado(type= quieres)
                Thread.sleep(2000)
            }
            else {
                println("Pasando a seleccion de café...")
                Thread.sleep(2000)
            }
        }
        override fun toString(): String {
            return "Idle"
        }
    }
    data class SelectCoffee(val type: Cafe) : CoffeeMachineState(){
        fun onEnter(){
            currentState = PaymentCoffee(monedero)
            println("Seleccionando cafe...")
            Thread.sleep(2000)
            println("Cafe seleccionado: " + nombreCafe.name)
            Thread.sleep(2000)
        }
        override fun toString(): String {
            return "SelectCoffee"
        }
    }
    data class PaymentCoffee(val type: Int) : CoffeeMachineState(){
        fun onEnter(){
            println("Paga el café.")
            Thread.sleep(2000)
            currentState = MakingCoffee(nombreCafe)
            if (monedero >= nombreCafe.precio) {
                println("Café Pagado")
                Thread.sleep(2000)
            } else{
                println("Error, no hay suficiente dinero en el monedero....")
                currentState = Error(
                    monedero,
                )
                Thread.sleep(2000)
            }}
        override fun toString(): String {
            return "PaymentCoffee"
        }
    }
    data class MakingCoffee(val type: Cafe) : CoffeeMachineState(){
        fun onEnter(){
            currentState = ServingCoffee(type = nombreCafe)
            println("¡Espera! La máquina ya está haciendo café.")
            Thread.sleep(5000)
        }
        override fun toString(): String {
            return "MakingCoffee"
        }
    }
    data class ServingCoffee(val type: Cafe) : CoffeeMachineState(){
        fun onEnter(){
            currentState = Idle
            println("Ya hay café servido. Por favor, toma tu café.")
        }
        override fun toString(): String {
            return "ServingCoffee"
        }
    }
    data class Apagado(val type: Boolean) : CoffeeMachineState(){
        fun onEnter(){
            println("Máquina apagada: Desea encenderla?")
            currentState = Idle
            println("Máquina encendida:  Empezando a hacer café...")
            Thread.sleep(2000)
        }
        override fun toString(): String {
            return "Apagado"
        }
    }
    data class Error(val type: Int) : CoffeeMachineState(){
        fun onEnter(){
            println("La máquina tiene un error:")
            Thread.sleep(2000)
            println("Solucionando el error....")
            Thread.sleep(2000)
            currentState = Idle
        }
        override fun toString(): String {
            return "Error"
        }
    }
}