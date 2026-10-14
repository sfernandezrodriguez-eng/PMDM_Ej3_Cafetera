package org.example

sealed class CoffeeMachineState {
    object Idle : CoffeeMachineState()
    object SelectCoffee : CoffeeMachineState()
    object PaymentCoffee : CoffeeMachineState()
    data class MakingCoffee(val type: String) : CoffeeMachineState()
    object ServingCoffee : CoffeeMachineState()
    object Apagado : CoffeeMachineState()
    object Error : CoffeeMachineState()
}