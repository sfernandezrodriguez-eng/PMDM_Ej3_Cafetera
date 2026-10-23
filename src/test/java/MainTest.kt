package org.example
import org.example.CoffeeMachine.monedero
import org.example.CoffeeMachine.nombreCafe
import org.example.CoffeeMachine.quieres
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
class MainTest {

    @BeforeTest
    fun resetMachineBeforeTest() {
        resetMachine()
    }

    @AfterTest
    fun resetMachineAfterTest() {
        resetMachine()
    }


    @Test
    fun goingToSelect() {
        CoffeeMachine.gestorEstados()
        assertEquals(
            CoffeeMachineState.SelectCoffee(nombreCafe),
            CoffeeMachine.currentState
        )

    }

    @Test
    fun goingToPayment() {
        CoffeeMachine.currentState = CoffeeMachineState.SelectCoffee(nombreCafe)
        CoffeeMachine.monedero = 10
        CoffeeMachine.gestorEstados()

        assertEquals(
            CoffeeMachineState.PaymentCoffee(monedero),
            CoffeeMachine.currentState
        )

    }

    @Test
    fun goingToMaking() {
        CoffeeMachine.monedero = 10
        CoffeeMachine.currentState = CoffeeMachineState.PaymentCoffee(monedero)
        CoffeeMachine.gestorEstados()

        assertEquals(
            CoffeeMachineState.MakingCoffee(nombreCafe),
            CoffeeMachine.currentState
        )

    }

    @Test
    fun goingToServing() {
        CoffeeMachine.currentState = CoffeeMachineState.MakingCoffee(nombreCafe)
        CoffeeMachine.gestorEstados()


        assertEquals(
            CoffeeMachineState.ServingCoffee(nombreCafe),
            CoffeeMachine.currentState
        )

    }

    @Test
    fun goingToIdle() {
        CoffeeMachine.currentState = CoffeeMachineState.ServingCoffee(nombreCafe)
        CoffeeMachine.gestorEstados()


        assertEquals(
            CoffeeMachineState.Idle,
            CoffeeMachine.currentState
        )

    }


    @Test
    fun goingToTurnOut() {
        CoffeeMachine.quieres = false
        CoffeeMachine.gestorEstados()

        assertEquals(
            CoffeeMachineState.Apagado(quieres),
            CoffeeMachine.currentState
        )

    }

    @Test
    fun notEnoughMoney() {
        CoffeeMachine.nombreCafe = Cafe.CAFE_LECHE
        CoffeeMachine.currentState = CoffeeMachineState.PaymentCoffee(monedero)
        CoffeeMachine.gestorEstados()

        assertEquals(
            CoffeeMachineState.Error(monedero),
            CoffeeMachine.currentState
        )

    }


    private fun resetMachine() {
        CoffeeMachine.monedero = 0
        CoffeeMachine.quieres = true
        CoffeeMachine.nombreCafe = Cafe.CAFE_LECHE
        CoffeeMachine.currentState = CoffeeMachineState.Idle
    }

}