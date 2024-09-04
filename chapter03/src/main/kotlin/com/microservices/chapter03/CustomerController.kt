package com.microservices.chapter03

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.beans.factory.annotation.Autowired
import java.util.concurrent.ConcurrentHashMap

@RestController
class CustomerController {
    
    @Autowired
    private lateinit var customerService: CustomerService

    @GetMapping("/customers")
    fun getCustomers(@RequestParam(required = false, defaultValue = "") nameFilter: String) =
        customerService.searchCustomers(nameFilter)

    @GetMapping("/customer/{id}")
    fun getCustomer(@PathVariable id: Int) = customerService.getCustomer(id)

    @PostMapping("/customer/")
    fun createCustomer(@RequestBody customer: Customer) {
        customerService.createCustomer(customer)
    }

    @DeleteMapping("/customer/{id}")
    fun deleteCustomer(@PathVariable id: Int) {
        customerService.deleteCustomer(id)
    }

    @PutMapping("/customer/{id}")
    fun updateCustomer(@PathVariable id: Int, @RequestBody customer: Customer) {
        customerService.updateCustomer(id, customer)
    }
  
}
