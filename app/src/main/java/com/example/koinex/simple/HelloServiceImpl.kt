package com.example.koinex.simple

/**
 * Our HelloService interface implementation class
 * */
class HelloServiceImpl(private val helloMessageData: HelloMessageData) : HelloService {

    override fun sayHello(): String = "Hey, ${helloMessageData.message}"

}