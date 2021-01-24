package com.example.koinex.ex4

class HTTPClient constructor(private val url: String) {

    fun doCall() {
        println("I am doing call with url: $url")
    }
}