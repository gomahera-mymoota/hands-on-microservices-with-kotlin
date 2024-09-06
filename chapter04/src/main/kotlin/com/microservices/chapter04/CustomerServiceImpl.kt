package com.microservices.chapter04

import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap
import reactor.kotlin.core.publisher.toMono
import reactor.kotlin.core.publisher.toFlux
import reactor.core.publisher.Mono

@Component
class CustomerServiceImpl : CustomerService {

    companion object {
        val initialCustomers = arrayOf(Customer(1, "Kotlin"),
            Customer(2, "Spring"),
            Customer(3, "Microservices", Customer.Telephone("+44", "1357924680")))
    }

    val customers = ConcurrentHashMap<Int, Customer>(initialCustomers.associateBy(Customer::id))

    override fun getCustomer(id: Int) = customers[id]?.toMono()

    override fun searchCustomers(nameFilter: String) = customers.filter {
        it.value.name.contains(nameFilter, true)
    }.map(Map.Entry<Int, Customer>::value).toFlux()

    override fun createCustomer(customerMono: Mono<Customer>): Mono<*> =
        customerMono.map {
            customers[it.id] = it
            it
        }

}