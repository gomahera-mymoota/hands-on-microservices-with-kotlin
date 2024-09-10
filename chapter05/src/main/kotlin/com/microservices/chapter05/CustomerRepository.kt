package com.microservices.chapter05

import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import jakarta.annotation.PostConstruct


@Repository
class CustomerRepository(private val template: ReactiveMongoTemplate) {

    companion object {
        val initialCustomers = listOf(Customer(1, "Kotlin"),
        Customer(2, "Spring"),
        Customer(3, "Microservice", Customer.Telephone("+82", "01062821234")))
    }

    @PostConstruct
    fun initRepository() =
        initialCustomers.map(Customer::toMono).map(this::create).map(Mono<Customer>::subscribe)
        // initialCustomers.map(Customer::toMono).map(this::create).map {
        //     it.subscribe {
        //         println("Default customer ${it.id} created")
        //     }
        // }

    fun create(customer: Mono<Customer>) = template.save(customer)

}