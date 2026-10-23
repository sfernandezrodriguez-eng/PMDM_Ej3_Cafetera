package org.example


/**
 * Singleton que maneja lo que ocurre en cada estado
 */
object CoffeeMachine {
    public var currentState: CoffeeMachineState = CoffeeMachineState.Idle
    public var monedero: Int = 0
    public var nombreCafe: Cafe = Cafe.CAFE_LECHE
    public var quieres:  Boolean = true

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
    fun clean() {
        println("Limpiando la máquina...")
        currentState = CoffeeMachineState.Idle
        println("Máquina limpia. Estado: $currentState")
    }
}