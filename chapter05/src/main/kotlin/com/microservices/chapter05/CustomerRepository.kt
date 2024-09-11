package com.microservices.chapter05

import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.findById
import org.springframework.data.mongodb.core.remove
import org.springframework.data.mongodb.core.find
import org.springframework.data.mongodb.core.query.Criteria.where
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.data.mongodb.core.query.Query
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

    fun findById(id: Int) = template.findById<Customer>(id)

    fun deleteById(id: Int) = 
        template.remove<Customer>(
            Query(where("_id").isEqualTo(id))
        )

    fun findCustomer(nameFilter: String) = 
        template.find<Customer>(
            Query(where("name").regex(".*$nameFilter.*", "i"))
        )

}