package org.example


/**
 * Singleton que maneja lo que ocurre en cada estado
 */
object CoffeeMachine {
    var currentState: CoffeeMachineState = CoffeeMachineState.Idle
    var monedero: Int = 0
    var nombreCafe: Cafe = Cafe.CAFE_LECHE
    var quieres:  Boolean = true

    fun gestorEstados() {

        when (val state = currentState) {
            is CoffeeMachineState.Idle -> state.onEnter()

            is CoffeeMachineState.SelectCoffee -> state.onEnter()

            is CoffeeMachineState.PaymentCoffee -> state.onEnter()

            is CoffeeMachineState.MakingCoffee -> state.onEnter()

            is CoffeeMachineState.ServingCoffee -> state.onEnter()

            is CoffeeMachineState.Error -> state.onEnter()

            is CoffeeMachineState.Apagado -> state.onEnter()

        }
    }
}