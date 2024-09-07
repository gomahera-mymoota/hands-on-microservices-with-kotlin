package com.microservices.chapter04

import reactor.core.publisher.Mono
import reactor.core.publisher.Flux

interface CustomerService {

    fun getCustomer(id: Int): Mono<Customer>
    fun searchCustomers(nameFilter: String): Flux<Customer>
    fun createCustomer(customerMono: Mono<Customer>): Mono<*>
    
}