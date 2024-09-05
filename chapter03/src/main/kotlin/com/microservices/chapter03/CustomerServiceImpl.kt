package com.microservices.chapter03

import java.util.concurrent.ConcurrentHashMap
import org.springframework.stereotype.Component

import com.microservices.chapter03.Customer.Telephone

@Component
class CustomerServiceImpl : CustomerService {

    companion object {
        val initialCustomers = arrayOf(Customer(1, "Kotlin"),
            Customer(2, "Spring"),
            Customer(3, "Microservices", Telephone("+351", "3987654321")))
    }

    val customers = ConcurrentHashMap<Int, Customer>(initialCustomers.associateBy(Customer::id))

    override fun getCustomer(id: Int) = customers[id]

    override fun createCustomer(customer: Customer) {
        customers[customer.id] = customer
     }

    override fun deleteCustomer(id: Int) {
        customers.remove(id)
    }

    override fun updateCustomer(id: Int, customer: Customer) {
        deleteCustomer(id)
        createCustomer(customer)
    }

    override fun searchCustomers(nameFilter: String): List<Customer> = 
        customers.filter {
            it.value.name.contains(nameFilter, true)
        }.map(Map.Entry<Int, Customer>::value).toList()

}