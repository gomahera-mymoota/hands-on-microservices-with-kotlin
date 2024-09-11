package com.microservices.chapter05

import reactor.core.publisher.Mono


interface CustomerService {

    fun getCustomer(id: Int): Mono<Customer>
    fun createCustomer(customer: Mono<Customer>): Mono<Customer>
    fun deleteCustomer(id: Int): Mono<Boolean>
    
}