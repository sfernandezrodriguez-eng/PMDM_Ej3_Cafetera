package org.example

sealed class CoffeeMachineState {
    object Idle : CoffeeMachineState(){
        override fun toString(): String {
            return "Idle"
        }
    }
    object SelectCoffee : CoffeeMachineState(){
        override fun toString(): String {
            return "SelectCoffee"
        }
    }
    object PaymentCoffee : CoffeeMachineState(){
        override fun toString(): String {
            return "PaymentCoffee"
        }
    }
    data class MakingCoffee(val type: String) : CoffeeMachineState(){
        override fun toString(): String {
            return "MakingCoffee"
        }
    }
    object ServingCoffee : CoffeeMachineState(){
        override fun toString(): String {
            return "ServingCoffee"
        }
    }
    object Apagado : CoffeeMachineState(){
        override fun toString(): String {
            return "Apagado"
        }
    }
    object Error : CoffeeMachineState(){
        override fun toString(): String {
            return "Error"
        }
    }
}