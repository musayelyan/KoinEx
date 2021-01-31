package com.example.koinex.zvExample

class Car constructor(val engine: Engine) {

    fun run() {
        engine.burnEnergy()
        println("Car is running")
    }
}