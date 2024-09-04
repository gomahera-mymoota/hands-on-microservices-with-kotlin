package com.microservices.chapter03

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@RestController
class CustomerController {
    
    @RequestMapping(value = arrayOf("/customer"), method = arrayOf(RequestMethod.GET))
    fun getCustomer() = Customer(1, "Kotlin")
}
