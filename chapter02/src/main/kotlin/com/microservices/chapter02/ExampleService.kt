package com.microservices.chapter02

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Value

// 1
// @Service
// class ExampleService {
//     fun getHello(name: String) = "hello $name"
// }


// 2
// @Service
// class ExampleService : ServiceInterface {

//     override fun getHello(name: String) = "hello $name"

// }


// 3
// @Service
// class ExampleService : ServiceInterface {

//     @Value("\${service.message.text}")
//     private lateinit var text: String

//     override fun getHello(name: String) = "$text $name"

// }

// 4
class ExampleService : ServiceInterface {
    @Value("\${service.message.text}")
    private lateinit var text: String
    
    override fun getHello(name: String) = "$text $name"
}