package com.example.koinex.ex3

class Car(private val engine: Engine) {

    fun carWork() {
        engine.engineWork()
        println("Car goes on")
    }
}