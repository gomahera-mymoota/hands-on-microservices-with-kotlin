package com.microservices.chapter05

import com.microservices.chapter05.Customer.Telephone
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import jakarta.annotation.PostConstruct


@Component
class DatabaseInitializer {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @Autowired
    lateinit var mongoOperations: ReactiveMongoOperations

    companion object {
        val initialCustomers = listOf(Customer(1, "Kotlin"),
        Customer(2, "Spring"),
        Customer(3, "Microservice", Telephone("+82", "01062821234")))
    }

    @PostConstruct
    fun initData() =
        customerRepository.saveAll(initialCustomers).subscribe {
            println("Default customer ${it.id} created")
        }

}