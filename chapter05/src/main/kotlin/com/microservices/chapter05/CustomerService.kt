package com.microservices.chapter05

import reactor.core.publisher.Mono
import reactor.core.publisher.Flux


interface CustomerService {

    fun getCustomer(id: Int): Mono<Customer>
    fun createCustomer(customer: Mono<Customer>): Mono<Customer>
    fun deleteCustomer(id: Int): Mono<Boolean>
    fun searchCustomer(nameFilter: String): Flux<Customer>
    
}