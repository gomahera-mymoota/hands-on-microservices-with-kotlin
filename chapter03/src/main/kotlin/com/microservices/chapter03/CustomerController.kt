package com.microservices.chapter03

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.beans.factory.annotation.Autowired
import java.util.concurrent.ConcurrentHashMap

@RestController
class CustomerController {
    
    @Autowired
    lateinit var customers: ConcurrentHashMap<Int, Customer>

    @RequestMapping(value = arrayOf("/customer"), method = arrayOf(RequestMethod.GET))
    fun getCustomer() = customers[2]
    
}
