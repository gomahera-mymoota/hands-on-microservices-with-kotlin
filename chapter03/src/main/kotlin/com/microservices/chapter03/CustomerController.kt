package com.microservices.chapter03

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.beans.factory.annotation.Autowired
import java.util.concurrent.ConcurrentHashMap

@RestController
class CustomerController {
    
    @Autowired
    lateinit var customers: ConcurrentHashMap<Int, Customer>

    @RequestMapping(value = arrayOf("/customer/{id}"), method = arrayOf(RequestMethod.GET))
    fun getCustomer(@PathVariable id: Int) = customers[id]

    @RequestMapping(value = arrayOf("/customers"), method = arrayOf(RequestMethod.GET))
    fun getCustomers() = customers.map(Map.Entry<Int, Customer>::value).toList()
    
}
