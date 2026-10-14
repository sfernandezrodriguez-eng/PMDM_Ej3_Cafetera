package org.example


/**
 * Singleton que maneja lo que ocurre en cada estado
 */
object CoffeeMachine {
    public var currentState: CoffeeMachineState = CoffeeMachineState.Idle

    fun gestorEstados(nombreCafe: Cafe, pago:Double) {
        println("Estado actual: $currentState")

        when (currentState) {
            is CoffeeMachineState.Idle -> {
                currentState = CoffeeMachineState.SelectCoffee
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
                currentState = CoffeeMachineState.PaymentCoffee
                println("Seleccionando cafe...")
                Thread.sleep(2000)
                if(nombreCafe!=null) {
                    println("Cafe seleccionado: " + nombreCafe.name)
                    Thread.sleep(2000)
                }

            }

            is CoffeeMachineState.PaymentCoffee -> {

                println("Paga el café.")
                Thread.sleep(2000)
                currentState = CoffeeMachineState.MakingCoffee(type = nombreCafe.nombre)
                println("¡Café listo! Estado: Pagado")

            }
            is CoffeeMachineState.MakingCoffee -> {
                currentState = CoffeeMachineState.ServingCoffee
                println("¡Espera! La máquina ya está haciendo café.")
            }
            is CoffeeMachineState.ServingCoffee -> {
                currentState = CoffeeMachineState.Idle
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

            CoffeeMachineState.Idle -> TODO()
        }
    }
}