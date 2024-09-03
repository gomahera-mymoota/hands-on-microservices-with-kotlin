package com.microservices.chapter02

import org.springframework.beans.factory.annotation.Value

class AdvancedService : ServiceInterface {

    @Value("\${service.message.text}")
    private lateinit var text: String
    private var count = 0

    override fun getHello(name: String): String {
        count++
        return "$text $name ($count)"
    }

}