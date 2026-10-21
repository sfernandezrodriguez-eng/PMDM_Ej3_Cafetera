package org.example

sealed class CoffeeMachineState {
    object Idle : CoffeeMachineState(){
        override fun toString(): String {
            return "Idle"
        }
    }
    data class SelectCoffee(val type: Cafe) : CoffeeMachineState(){
        override fun toString(): String {
            return "SelectCoffee"
        }
    }
    data class PaymentCoffee(val type: Cafe) : CoffeeMachineState(){
        override fun toString(): String {
            return "PaymentCoffee"
        }
    }
    data class MakingCoffee(val type: String) : CoffeeMachineState(){
        override fun toString(): String {
            return "MakingCoffee"
        }
    }
    data class ServingCoffee(val type: Cafe) : CoffeeMachineState(){
        override fun toString(): String {
            return "ServingCoffee"
        }
    }
    data class Apagado(val type: Boolean) : CoffeeMachineState(){
        override fun toString(): String {
            return "Apagado"
        }
    }
    data class Error(val message: String) : CoffeeMachineState(){
        override fun toString(): String {
            return "Error"
        }
    }
}