package com.microservices.chapter04

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@RestController
class CustomerController {

    @GetMapping("/customer/{id}")
    fun getCustomer(@PathVariable id: Int) = Customer(id, "customer $id")
    
}