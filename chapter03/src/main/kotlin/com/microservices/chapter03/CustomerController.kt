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
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import java.util.concurrent.ConcurrentHashMap

@RestController
class CustomerController {
    
    @Autowired
    private lateinit var customerService: CustomerService

    @GetMapping("/customers")
    fun getCustomers(@RequestParam(required = false, defaultValue = "") nameFilter: String) =
        customerService.searchCustomers(nameFilter)

    @GetMapping("/customer/{id}")
    fun getCustomer(@PathVariable id: Int): ResponseEntity<Customer?> {
        val customer = customerService.getCustomer(id)
        val status = if (customer == null) HttpStatus.NOT_FOUND else HttpStatus.OK

        return ResponseEntity(customer, status)
    }

    @PostMapping("/customer/")
    fun createCustomer(@RequestBody customer: Customer): ResponseEntity<Unit> {
        customerService.createCustomer(customer)

        return ResponseEntity(Unit, HttpStatus.CREATED)
    }

    @DeleteMapping("/customer/{id}")
    fun deleteCustomer(@PathVariable id: Int): ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND

        if (customerService.getCustomer(id) != null) {
            customerService.deleteCustomer(id)
            status = HttpStatus.OK
        }

        return ResponseEntity(Unit, status)
    }

    @PutMapping("/customer/{id}")
    fun updateCustomer(@PathVariable id: Int, 
                       @RequestBody customer: Customer): ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND

        if (customerService.getCustomer(id) != null) {
            customerService.updateCustomer(id, customer)
            status = HttpStatus.ACCEPTED
        }

        return ResponseEntity(Unit, status)
    }
  
}
