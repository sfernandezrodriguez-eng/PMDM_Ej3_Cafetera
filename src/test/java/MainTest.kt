package org.example
import org.example.CoffeeMachine.nombreCafe
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
    fun followsTheScenarioFromMain() {
        CoffeeMachine.nombreCafe = Cafe.CAFE_LECHE
        CoffeeMachine.currentState = CoffeeMachineState.SelectCoffee(nombreCafe)

        assertEquals(
            CoffeeMachineState.SelectCoffee(Cafe.CAFE_LECHE),
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