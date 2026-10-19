package org.example


/**
 * Singleton que maneja lo que ocurre en cada estado
 */
object CoffeeMachine {
    public var currentState: CoffeeMachineState = CoffeeMachineState.Idle

    fun gestorEstados(nombreCafe: Cafe, monedero:Double, quieres:Boolean) {
        println("Estado actual: ${currentState.toString()}")

        when (currentState) {
            is CoffeeMachineState.Idle -> {
                currentState = CoffeeMachineState.SelectCoffee
                println("Bienvenido, quiere hacer un cafe? Si o no")
                Thread.sleep(2000)
                if (quieres == false) {
                    println("Ok, apagando maquina....")
                    currentState = CoffeeMachineState.Apagado
                    Thread.sleep(2000)
                }
                else {
                    println("Pasando a seleccion de café...")
                    Thread.sleep(2000)
                }
            }

            is CoffeeMachineState.SelectCoffee -> {
                currentState = CoffeeMachineState.PaymentCoffee
                println("Seleccionando cafe...")
                Thread.sleep(2000)
                println("Cafe seleccionado: " + nombreCafe.name)
                Thread.sleep(2000)

            }

            is CoffeeMachineState.PaymentCoffee -> {

                println("Paga el café.")
                Thread.sleep(2000)
                currentState = CoffeeMachineState.MakingCoffee(type = nombreCafe.nombre)
                if (monedero >= nombreCafe.precio) {
                    println("Café Pagado")
                    Thread.sleep(2000)
                } else{
                    println("Error, no hay suficiente dinero en el monedero....")
                    currentState = CoffeeMachineState.Error
                    Thread.sleep(2000)
                }
            }

            is CoffeeMachineState.MakingCoffee -> {
                currentState = CoffeeMachineState.ServingCoffee
                println("¡Espera! La máquina ya está haciendo café.")
                Thread.sleep(5000)
            }

            is CoffeeMachineState.ServingCoffee -> {
                currentState = CoffeeMachineState.Idle
                println("Ya hay café servido. Por favor, toma tu café.")
            }

            is CoffeeMachineState.Error -> {
                println("La máquina tiene un error:")
                Thread.sleep(2000)
                println("Solucionando el error....")
                Thread.sleep(2000)
                currentState = CoffeeMachineState.Idle
            }

            is CoffeeMachineState.Apagado -> {
                println("Máquina apagada: Desea encenderla?")
                currentState = CoffeeMachineState.Idle
                println("Máquina encendida desde:  Empezando a hacer café...")
                Thread.sleep(2000)
            }
            CoffeeMachineState.Idle -> TODO()
        }
    }
}